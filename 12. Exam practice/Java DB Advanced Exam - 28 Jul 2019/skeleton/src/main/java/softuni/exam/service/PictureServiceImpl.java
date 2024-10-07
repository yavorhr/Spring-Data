package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.models.xml.PicturesRootModel;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PictureServiceImpl implements PictureService {
  private static final String PICTURES_FILE_PATH = "src/main/resources/files/xml/pictures.xml";
  private final ModelMapper modelMapper;
  private final PictureRepository pictureRepository;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;

  public PictureServiceImpl(ModelMapper modelMapper, PictureRepository pictureRepository, ValidationUtil validationUtil, XmlParser xmlParser) {
    this.modelMapper = modelMapper;
    this.pictureRepository = pictureRepository;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
  }

  @Override
  public String importPictures() throws JAXBException {
    StringBuilder sb = new StringBuilder();

    this.xmlParser.fromFile(PICTURES_FILE_PATH, PicturesRootModel.class).getPictures()
            .stream()
            .filter(dto -> {

              boolean isValid = this.validationUtil.isValid(dto);

              sb.append(isValid
                      ? String.format("Successfully imported picture - %s", dto.getUrl())
                      : "Invalid picture")
                      .append(System.lineSeparator());
              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, Picture.class))
            .forEach(this.pictureRepository::save);


    return sb.toString().trim();
  }

  @Override
  public boolean areImported() {
    return this.pictureRepository.count() > 0;
  }

  @Override
  public String readPicturesXmlFile() throws IOException {
    return Files.readString(Path.of(PICTURES_FILE_PATH));
  }

  @Override
  public Picture findPictureByUrl(String url) {
    return this.pictureRepository.findByUrl(url).get();
  }

  @Override
  public boolean doesPictureExistByURL(String url) {
    return this.pictureRepository.findByUrl(url).isPresent();
  }

}
