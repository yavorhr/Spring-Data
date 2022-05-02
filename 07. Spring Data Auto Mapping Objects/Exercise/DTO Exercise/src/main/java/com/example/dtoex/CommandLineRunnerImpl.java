package com.example.dtoex;

import com.example.dtoex.model.dto.GameAddDto;
import com.example.dtoex.model.dto.UserLoginDto;
import com.example.dtoex.model.dto.UserRegisterDto;
import com.example.dtoex.service.GameService;
import com.example.dtoex.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    //Създавайки private final bufferedReader() и инициализирайки го в constructor, ние можем да
    //го използваме постоянно в нашия клас, без да се налага всеки път да го извикваме наново. Ще ипозлваме
    //само bufferedReader, а извикването ще става през конструктора автоматично.
    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter your commands: ");
            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0]) {
                case "RegisterUser" -> userService.registerUser(new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));
                case "LoginUser" -> userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                case "Logout" -> userService.logoutUser();
                case "AddGame" -> gameService.addGame(
                        new GameAddDto(commands[1],
                                new BigDecimal(commands[2]),
                                Double.parseDouble(commands[3]),
                                commands[4],
                                commands[5],
                                commands[6],
                                commands[7]));
                case "editGame" -> gameService.editGame(Long.parseLong(
                        commands[1])
                        , BigDecimal.valueOf(Double.parseDouble(commands[2]))
                        , Double.parseDouble(commands[3]));
            }
        }
    }
}
