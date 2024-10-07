package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.PositionEnum;
import softuni.exam.domain.models.json.PlayerModel;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
  private static final String PLAYERS_FILE_PATH = "src/main/resources/files/json/players.json";
  private final ModelMapper modelMapper;
  private final PlayerRepository playerRepository;
  private final ValidationUtil validationUtil;
  private final Gson gson;
  private final PictureService pictureService;
  private final TeamService teamService;

  public PlayerServiceImpl(ModelMapper modelMapper, PlayerRepository playerRepository, ValidationUtil validationUtil, Gson gson, PictureService pictureService, TeamService teamService) {
    this.modelMapper = modelMapper;
    this.playerRepository = playerRepository;
    this.validationUtil = validationUtil;
    this.gson = gson;
    this.pictureService = pictureService;
    this.teamService = teamService;
  }

  @Override
  public String importPlayers() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readPlayersJsonFile(), PlayerModel[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (invalidPosition(dto.getPosition())
                      || invalidImageUrl(dto.getTeam().getPicture().getUrl())
                      || invalidImageUrl(dto.getPicture().getUrl())
                      || invalidTeam(dto.getTeam().getName())) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported player: %s %s",
                      dto.getFirstName(),
                      dto.getLastName())
                      : "Invalid Player")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Player entity = this.modelMapper.map(dto, Player.class);
              entity.setTeam(this.teamService.findTeamByName(dto.getTeam().getName()));
              entity.setPicture(this.pictureService.findPictureByUrl(dto.getPicture().getUrl()));

              return entity;
            })
            .forEach(this.playerRepository::save);

    return sb.toString().trim();
  }

  @Override
  public boolean areImported() {
    return this.playerRepository.count() > 0;
  }

  @Override
  public String readPlayersJsonFile() throws IOException {
    return Files.readString(Path.of(PLAYERS_FILE_PATH));
  }

  @Override
  public String exportPlayersWhereSalaryBiggerThan() {
    StringBuilder sb = new StringBuilder();

    this.playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000))
            .forEach(p -> {
              sb.append(String.format("Player name: %s %s\n" +
                              "\tNumber: %d\n" +
                              "\tSalary: %s\n" +
                              "\tTeam: %s\n",
                      p.getFirstName(),
                      p.getLastName(),
                      p.getNumber(),
                      p.getSalary(),
                      p.getTeam().getName()));
            });

    return sb.toString().trim();
  }

  @Override
  public String exportPlayersInATeam() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("Team: %s\n", "North Hub"));

    this.playerRepository.findAllByTeamNameOrderById("North Hub")
            .forEach(p -> {
              sb.append(String.format("\tPlayer name: %s %s - %s\n" +
                              "\tNumber: %d\n",
                      p.getFirstName(),
                      p.getLastName(),
                      p.getPosition().name(),
                      p.getNumber()
              ));
            });

    return sb.toString();
  }

  // Helpers
  private boolean invalidPosition(PositionEnum position) {
    return position == null;
  }

  private boolean invalidImageUrl(String url) {
    return !this.pictureService.doesPictureExistByURL(url);
  }

  private boolean invalidTeam(String name) {
    return this.teamService.findTeamByName(name) == null;
  }

}
