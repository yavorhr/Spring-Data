package com.example.demo_test.Services;

import com.example.demo_test.Exceptions.InsufficientFundsException;
import com.example.demo_test.Exceptions.NotExistincAccount;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;


public interface AccountService {

    void withdrawMoney(BigDecimal money, Long id) throws NotExistincAccount, InsufficientResourcesException, InsufficientFundsException;

    void transferMoney(BigDecimal money, Long id) throws NotExistincAccount;

    void transferMoneyBetweenUsers(Long from, Long to, BigDecimal amount) throws NotExistincAccount, InsufficientFundsException;
}
