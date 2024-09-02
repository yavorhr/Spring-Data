package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.OffersRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
  private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
  private final OfferRepository offerRepository;
  private final XmlParser xmlParser;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final AgentService agentService;
  private final ApartmentService apartmentService;

  public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, AgentService agentService, ApartmentService apartmentService) {
    this.offerRepository = offerRepository;
    this.xmlParser = xmlParser;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.agentService = agentService;

    this.apartmentService = apartmentService;
  }

  @Override
  public boolean areImported() {
    return this.offerRepository.count() > 0;
  }

  @Override
  public String readOffersFileContent() throws IOException {
    return Files.readString(Path.of(OFFERS_FILE_PATH));
  }

  @Override
  public String importOffers() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    OffersRootDto rootDto = this.xmlParser.fromFile(OFFERS_FILE_PATH, OffersRootDto.class);

    rootDto.getOffers()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (this.agentService.findAgentByFirstName(
                      dto.getAgent().getFirstName()).isEmpty()) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported offer %.2f",
                      dto.getPrice())
                      : "Invalid offer")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Offer offer = this.modelMapper.map(dto, Offer.class);
              Optional<Agent> town = this.agentService.findAgentByFirstName(dto.getAgent().getFirstName());

              town.ifPresent(offer::setAgent);
              offer.setApartment(this.apartmentService.findById(dto.getApartment().getId()));

              return offer;
            })
            .forEach(this.offerRepository::save);

    return sb.toString().trim();
  }

  @Override
  public String exportOffers() throws JAXBException {


    return null;
  }
}
