package com.example.football.service.impl;

import com.example.football.models.dto.xml.StatsRootModel;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {
  private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

  private final StatRepository statRepository;
  private final ModelMapper modelMapper;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;

  public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
    this.statRepository = statRepository;
    this.modelMapper = modelMapper;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
  }


  @Override
  public boolean areImported() {
    return this.statRepository.count() > 0;
  }

  @Override
  public String readStatsFileContent() throws IOException {
    return Files.readString(Path.of(STATS_FILE_PATH));
  }

  @Override
  public String importStats() throws JAXBException {
    StringBuilder sb = new StringBuilder();
    StatsRootModel statsRootSeedDto = this.xmlParser.fromFile(STATS_FILE_PATH, StatsRootModel.class);

    List<Stat> collectStats = statsRootSeedDto.getStats()
            .stream()
            .filter(dto -> {

              boolean isValid = validationUtil.isValid(dto);

              sb
                      .append(isValid
                              ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                              dto.getShooting(),
                              dto.getPassing(),
                              dto.getEndurance())
                              : "Invalid Stat")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(statDetailsDto -> modelMapper.map(statDetailsDto, Stat.class))
            .collect(Collectors.toList());

    statRepository.saveAll(collectStats);

    return sb.toString();
  }

  @Override
  public Stat findStatsById(Long id) {
    return statRepository.findById(id).orElse(null);
  }
}
