package com.example.football.service.impl;

import com.example.football.models.dto.StatsRootSeedDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final XmlParse xmlParse;
    private final ValidationUtil validationUtil;

    private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, XmlParse xmlParse, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.xmlParse = xmlParse;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        StatsRootSeedDto statsRootSeedDto = xmlParse.fromFile(STATS_FILE_PATH, StatsRootSeedDto.class);

        List<Stat> collectStats = statsRootSeedDto.getStats()
                .stream()
                .filter(statDetailsDto -> {
                    boolean isValid = validationUtil.isValid(statDetailsDto);

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Stat %.2f - %.2f - %.2f", statDetailsDto.getShooting(), statDetailsDto.getPassing(), statDetailsDto.getEndurance())
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
