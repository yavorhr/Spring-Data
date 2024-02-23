package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.OfferSeedRootDto;
import softuni.exam.models.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final CarService carService;
    private final SellerService sellerService;

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        OfferSeedRootDto offerSeedRootDto = xmlParser.fromFile(OFFERS_FILE_PATH, OfferSeedRootDto.class);
        StringBuilder sb = new StringBuilder();
        offerSeedRootDto.getOffers()
                .stream()
                .filter(offerDetailsSeedDto -> {
                    boolean isValid = validationUtil.isValid(offerDetailsSeedDto);
                    sb.append(isValid ? String.format("Successfully import offer %s - %s"
                            , offerDetailsSeedDto.getAddedOn(), offerDetailsSeedDto.isHasGoldStatus())
                            : "Invalid offer").append(System.lineSeparator());
                    return isValid;
                })
                .map(offerDetailsSeedDto -> {

                    Offer offer = modelMapper.map(offerDetailsSeedDto, Offer.class);
                    offer.setCar(carService.findById(offerDetailsSeedDto.getCar().getId()));
                    offer.setSeller(sellerService.findById(offerDetailsSeedDto.getSeller().getId()));

                    return offer;
                })
                .forEach(offerRepository::save);

        return sb.toString();
    }
}
