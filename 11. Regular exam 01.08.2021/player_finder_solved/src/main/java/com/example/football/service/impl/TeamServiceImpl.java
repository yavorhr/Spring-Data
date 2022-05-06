package com.example.football.service.impl;

import com.example.football.models.dto.TeamsInputDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final TownService townService;

    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, TownService townService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();

        TeamsInputDto[] teamsInputDtos = gson.fromJson(readTeamsFileContent(), TeamsInputDto[].class);
        List<Team> collect = Arrays.stream(teamsInputDtos)
                .filter(teamsInputDto -> {
                    boolean isValid = validationUtil.isValid(teamsInputDto) && !existsEntityWithName(teamsInputDto.getName());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Team %s - %d", teamsInputDto.getName(), teamsInputDto.getFanBase())
                                    : "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamsInputDto -> {

                    Town town = townService.findByTownName(teamsInputDto.getTownName());
                    Team team = modelMapper.map(teamsInputDto, Team.class);

                    team.setTown(town);
                    return team;
                })
                .collect(Collectors.toList());

        teamRepository.saveAll(collect);
        return sb.toString();
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    private boolean existsEntityWithName(String teamName) {
        return teamRepository.existsByName(teamName);
    }
}
