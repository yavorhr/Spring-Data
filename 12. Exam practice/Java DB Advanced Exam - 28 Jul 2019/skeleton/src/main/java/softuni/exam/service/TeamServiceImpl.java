package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.models.xml.TeamDetailsModel;
import softuni.exam.domain.models.xml.TeamsRootModel;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TeamServiceImpl implements TeamService {
  private static final String PICTURES_FILE_PATH = "src/main/resources/files/xml/teams.xml";
  private final ModelMapper modelMapper;
  private final TeamRepository teamRepository;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;
  private final PictureService pictureService;

  public TeamServiceImpl(ModelMapper modelMapper, TeamRepository teamRepository, ValidationUtil validationUtil, XmlParser xmlParser, PictureService pictureService) {
    this.modelMapper = modelMapper;
    this.teamRepository = teamRepository;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
    this.pictureService = pictureService;
  }

  @Override
  public String importTeams() throws JAXBException {
    StringBuilder sb = new StringBuilder();

    this.xmlParser.fromFile(PICTURES_FILE_PATH, TeamsRootModel.class).getTeams()
            .stream()
            .filter(dto -> {

              boolean isValid = this.validationUtil.isValid(dto);

              if (!pictureService.doesPictureExistByURL(dto.getPicture().getUrl())) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported - %s", dto.getName())
                      : "Invalid team")
                      .append(System.lineSeparator());
              return isValid;
            })
            .map(dto -> {
              Team team = this.modelMapper.map(dto, Team.class);
              team.setPicture(findPictureByURL(dto));

              return team;
            })
            .forEach(this.teamRepository::save);

    return sb.toString().trim();
  }

  private Picture findPictureByURL(TeamDetailsModel dto) {
    return this.pictureService.findPictureByUrl(dto.getPicture().getUrl());
  }

  @Override
  public boolean areImported() {
    return this.teamRepository.count() > 0;
  }

  @Override
  public String readTeamsXmlFile() throws IOException {
    return Files.readString(Path.of(PICTURES_FILE_PATH));
  }

  @Override
  public Team findTeamByName(String name) {
    return this.teamRepository.findByName(name);
  }
}
