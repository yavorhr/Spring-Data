package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.PassengersInputDto;
import softuni.exam.models.Entity.Passenger;
import softuni.exam.models.Entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;

    private static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    public PassengerServiceImpl(PassengerRepository passengerRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService) {
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        PassengersInputDto[] passengers = gson.fromJson(readPassengersFileContent(), PassengersInputDto[].class);
        StringBuilder sb = new StringBuilder();
        List<String> emails = new ArrayList<>();

        Arrays.stream(passengers)
                .filter(passengerDto -> {
                    boolean isValid = validationUtil.isValid(passengerDto);

                    if (emails.contains(passengerDto.getEmail())) {
                        isValid = false;
                    } else {
                        emails.add(passengerDto.getEmail());
                    }

                    sb.append(isValid
                            ? String.format("Successfully imported Passenger %s - %s", passengerDto.getLastName(), passengerDto.getEmail())
                            : "Invalid Passenger")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(passengerDto -> {
            Town town = townService.findTownByName(passengerDto.getTown());
            Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
            passenger.setTown(town);
            return passenger;
        }).forEach(passengerRepository::save);


        return sb.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();
        Set<Passenger> passengers = passengerRepository.findAllPassengersOrderedByTicketsCountDescThenByEmailAsc();

        for (Passenger passenger : passengers) {
            sb.append(String.format("Passenger %s  %s\n" +
                            "\tEmail - %s\n" +
                            "\tPhone - %s\n" +
                            "\tNumber of tickets - %d\n",
                    passenger.getFirstName(),
                    passenger.getLastName(),
                    passenger.getEmail(),
                    passenger.getPhoneNumber(),
                    passenger.getTickets().size()));
        }
        return sb.toString().trim();
    }

    @Override
    public Passenger findPassengerByEmail(String email) {
        return passengerRepository.findPassengerByEmail(email);
    }
}
