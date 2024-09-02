package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.OffersRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.ApartmentTypeEnum;
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
import java.util.List;
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
    
    StringBuilder sb = new StringBuilder();
    this.offerRepository.findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentTypeEnum.three_rooms)
            .stream()
            .forEach(e -> sb.append(String.format("\"Agent %s %s with offer №%d:\n" +
                            "\t\t-Apartment area: %.2f\n" +
                            "\t\t--Town: %s\n" +
                            "\t\t---Price: %.2f$\n",
                    e.getAgent().getFirstName(),
                    e.getAgent().getLatName(),
                    e.getId(),
                    e.getApartment().getArea(),
                    e.getApartment().getTown().getTownName(),
                    e.getPrice()
            )).append(System.lineSeparator()));

    return sb.toString().trim();
  }
}
