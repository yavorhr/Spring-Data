package com.example.football.service.impl;

import com.example.football.models.dto.xml.playerDto.PlayerDetailsDto;
import com.example.football.models.dto.xml.playerDto.PlayersRootSeedDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.PositionEnum;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
  private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
  private final PlayerRepository playerRepository;
  private final TownService townService;
  private final TeamService teamService;
  private final StatService statService;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;

  public PlayerServiceImpl(PlayerRepository playerRepository, TownService townService, TeamService teamService, StatService statService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
    this.playerRepository = playerRepository;
    this.townService = townService;
    this.teamService = teamService;
    this.statService = statService;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
  }

  @Override
  public boolean areImported() {
    return this.playerRepository.count() > 0;
  }

  @Override
  public String readPlayersFileContent() throws IOException {
    return Files.readString(Path.of(PLAYERS_FILE_PATH));
  }

  @Override
  public String importPlayers() throws JAXBException {
    StringBuilder sb = new StringBuilder();
    PlayersRootSeedDto playersRootSeedDto = xmlParser.fromFile(PLAYERS_FILE_PATH, PlayersRootSeedDto.class);

    List<Player> playersList = playersRootSeedDto.getPlayers()
            .stream()
            .filter(dto -> {
              boolean isValid = validationUtil.isValid(dto);

              if (emailAlreadyExists(dto)) {
                isValid = false;
              }

              sb
                      .append(isValid
                              ? String.format("Successfully imported Player %s %s - %s",
                              dto.getFirstName(), dto.getLastName(), dto.getPosition())
                              : "Invalid Player")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {

              Player player = modelMapper.map(dto, Player.class);

              player.setTown(townService.findByTownName(dto.getTown().getName()));
              player.setTeam(teamService.findTeamByName(dto.getTeam().getName()).get());
              player.setStat(statService.findStatsById(dto.getStat().getId()));
              player.setPosition(PositionEnum.valueOf(dto.getPosition()));

              return player;
            })
            .collect(Collectors.toList());

    playerRepository.saveAll(playersList);

    return sb.toString().trim();
  }

  @Override
  public String exportBestPlayers() throws JAXBException {
    return "";
  }

  // Helpers
  private boolean emailAlreadyExists(PlayerDetailsDto dto) {
    return this.playerRepository.findByEmail(dto.getEmail()).isPresent();
  }
}
