package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.SellerSeedRootDto;
import softuni.exam.models.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private static final String PATH_TO_SELLERS_FILE = "src/main/resources/files/xml/sellers.xml";

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException, JAXBException {
        return Files.readString(Path.of(PATH_TO_SELLERS_FILE));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        SellerSeedRootDto sellerSeedRootDto = xmlParser.fromFile(PATH_TO_SELLERS_FILE, SellerSeedRootDto.class);
        StringBuilder sb = new StringBuilder();

        sellerSeedRootDto.getSellersList().stream().filter(sellerDetailsDto -> {
            boolean isValid = validationUtil.isValid(sellerDetailsDto);
            sb.append(isValid ? String.format("Successfully import seller %s - %s",
                    sellerDetailsDto.getLastName(), sellerDetailsDto.getEmail())
                    : "Invalid Seller").append(System.lineSeparator());
            return isValid;
        }).map(sellerDetailsDto -> modelMapper.map(sellerDetailsDto, Seller.class))
                .forEach(sellerRepository::save);

        return sb.toString();
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }
}
