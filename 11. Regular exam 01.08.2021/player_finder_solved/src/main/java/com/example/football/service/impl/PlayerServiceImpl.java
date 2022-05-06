package com.example.football.service.impl;

import com.example.football.models.dto.PlayersRootSeedDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Position;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    private final XmlParse xmlParse;

    public PlayerServiceImpl(PlayerRepository playerRepository, TownService townService, TeamService teamService, StatService statService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParse xmlParse) {
        this.playerRepository = playerRepository;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParse = xmlParse;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        PlayersRootSeedDto playersRootSeedDto = xmlParse.fromFile(PLAYERS_FILE_PATH, PlayersRootSeedDto.class);

        List<String> names = new ArrayList<>();

        List<Player> playersList = playersRootSeedDto.getPlayers()
                .stream()
                .filter(playerDetailsDto -> {
                    boolean isValid = validationUtil.isValid(playerDetailsDto);

                    if (names.contains(playerDetailsDto.getEmail())) {
                        isValid = false;
                    } else {
                        names.add(playerDetailsDto.getEmail());
                    }

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Player %s %s - %s",
                                    playerDetailsDto.getFirstName(), playerDetailsDto.getLastName(), playerDetailsDto.getPosition())
                                    : "Invalid Player")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(playerDetailsDto -> {

                    Player player = modelMapper.map(playerDetailsDto, Player.class);
                    LocalDate parse = LocalDate.parse(playerDetailsDto.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    player.setBirthDate(parse);
                    player.setTown(townService.findByTownName(playerDetailsDto.getTown().getName()));
                    player.setTeam(teamService.findTeamByName(playerDetailsDto.getTeam().getName()));
                    player.setStat(statService.findStatsById(playerDetailsDto.getStat().getId()));
                    player.setPosition(Position.valueOf(playerDetailsDto.getPosition()));

                    return player;
                })
                .collect(Collectors.toList());

        System.out.println();
        playerRepository.saveAll(playersList);
        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        Set<Player> bestPlayers = playerRepository.findBestPlayers();
        for (Player player : bestPlayers) {
            sb.append(String.format("Player - %s %s\n" +
                            "\tPosition - %s\n" +
                            "\tTeam - %s\n" +
                            "\tStadium - %s\n",
                    player.getFirstName(), player.getLastName(),
                    player.getPosition(), player.getTeam().getName(),
                    player.getTeam().getStadiumName()));
        }

        return sb.toString();
    }


}
