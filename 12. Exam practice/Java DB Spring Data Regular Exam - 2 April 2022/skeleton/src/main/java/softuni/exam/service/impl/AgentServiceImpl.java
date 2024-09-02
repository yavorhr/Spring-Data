package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.AgentsSeedDtos;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
  private static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";
  private final AgentRepository agentRepository;
  private final Gson gson;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final TownService townService;

  public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
    this.agentRepository = agentRepository;
    this.gson = gson;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.townService = townService;
  }

  @Override
  public boolean areImported() {
    return this.agentRepository.count() > 0;
  }

  @Override
  public String readAgentsFromFile() throws IOException {
    return Files.readString(Path.of(AGENTS_FILE_PATH));
  }

  @Override
  public String importAgents() throws IOException {
    StringBuilder sb = new StringBuilder();

    List<String> firstNamesOccurances = new ArrayList<>();
    List<String> emailOccurances = new ArrayList<>();

    Arrays.stream(this.gson.fromJson(readAgentsFromFile(), AgentsSeedDtos[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (isValid &&
                      !doesCollectionContainsElement(dto.getFirstName(), firstNamesOccurances) ||
                      !doesCollectionContainsElement(dto.getEmail(), emailOccurances)) {
                isValid = false;
              }

              sb.append(isValid ? String.format("Successfully imported agent - %s %S",
                      dto.getFirstName(),
                      dto.getLatName())
                      : "Invalid agent")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Agent agent = this.modelMapper.map(dto, Agent.class);

              Optional<Town> town = this.townService.findTownByName(dto.getTown());
              town.ifPresent(agent::setTown);

              return agent;
            }).forEach(this.agentRepository::save);

    return sb.toString().trim();
  }

  @Override
  public Optional<Agent> findAgentByFirstName(String firstName) {
    return this.agentRepository.findByFirstName(firstName);
  }

  // Helpers
  private boolean doesCollectionContainsElement(String string, List<String> collection) {
    if (collection.contains(string)) {
      return false;
    }

    collection.add(string);
    return true;
  }
}


