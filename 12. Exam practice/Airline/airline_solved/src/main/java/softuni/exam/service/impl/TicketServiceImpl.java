package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.TicketsRootDto;
import softuni.exam.models.Entity.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParse;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParse xmlParse;
    private final PlaneService planeService;
    private final PassengerService passengerService;
    private final TownService townService;


    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParse xmlParse, PlaneService planeService, PassengerService passengerService, TownService townService) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParse = xmlParse;
        this.planeService = planeService;
        this.passengerService = passengerService;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        List<String> serialNumbers = new ArrayList<>();
        TicketsRootDto ticketsRootDto = xmlParse.fromFile(TICKETS_FILE_PATH, TicketsRootDto.class);

        List<Ticket> collect = ticketsRootDto.getTickets()
                .stream()
                .filter(ticketDetailsDto -> {
                    boolean isValid = validationUtil.isValid(ticketDetailsDto);

                    if (serialNumbers.contains(ticketDetailsDto.getSerialNumber())) {
                        isValid = false;
                    } else {
                        serialNumbers.add(ticketDetailsDto.getSerialNumber());
                    }

                    sb.append(isValid
                            ? String.format("Successfully imported Ticket %s - %s", ticketDetailsDto.getFromTown().getName(), ticketDetailsDto.getToTown().getName())
                            : "Invalid Ticket")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(ticketDetailsDto -> {
                    Ticket ticket = modelMapper.map(ticketDetailsDto, Ticket.class);
                    String takeoff = ticketDetailsDto.getTakeoff();
                    //2020-08-12 17:53:35
                    LocalDateTime parse = LocalDateTime.parse(takeoff, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    ticket.setTakeoff(parse);
                    ticket.setToTown(townService.findToTownByName(ticketDetailsDto.getToTown().getName()));
                    ticket.setFromTown(townService.findToTownByName(ticketDetailsDto.getFromTown().getName()));
                    ticket.setPassenger(passengerService.findPassengerByEmail(ticketDetailsDto.getPassenger().getEmail()));
                    ticket.setPlane(planeService.findPlaneByRegNumber(ticketDetailsDto.getPlane().getRegisterNumber()));

                    return ticket;

                }).collect(Collectors.toList());


        ticketRepository.saveAll(collect);
        return sb.toString();
    }
}
