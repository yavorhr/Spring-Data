package com.example.demo_test;

import com.example.demo_test.Exceptions.InsufficientFundsException;
import com.example.demo_test.Services.AccountService;
import com.example.demo_test.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.userService.registerUser("Gosho",13, BigDecimal.valueOf(1000));
        //this.userService.addAccount(BigDecimal.valueOf(300),1L);

//        try {
//            this.accountService
//                    .withdrawMoney(BigDecimal.valueOf(200),1L);
//        } catch (InsufficientFundsException e) {
//            e.printStackTrace();
//        }


//        this.accountService
//                .transferMoney(BigDecimal.valueOf(1200),1L);

        try {
            this.accountService.transferMoneyBetweenUsers(2L, 1L, BigDecimal.valueOf(200));
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }


}
