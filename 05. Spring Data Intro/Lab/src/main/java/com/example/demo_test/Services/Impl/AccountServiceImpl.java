package com.example.demo_test.Services.Impl;

import com.example.demo_test.Exceptions.InsufficientFundsException;
import com.example.demo_test.Exceptions.NotExistincAccount;
import com.example.demo_test.Models.Account;
import com.example.demo_test.Repositories.AccountRepository;
import com.example.demo_test.Services.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.util.function.BiFunction;


@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) throws NotExistincAccount, InsufficientFundsException {

        Account account = findAccount(id);

        if (account.getBalance().compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }

        account.setBalance(account.getBalance().subtract(money));
        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) throws NotExistincAccount {
        Account account = findAccount(id);

        account.setBalance(account.getBalance().add(money));
        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void transferMoneyBetweenUsers(Long from, Long to, BigDecimal amount) throws NotExistincAccount, InsufficientFundsException {
       this.withdrawMoney(amount,from);
       this.transferMoney(amount,to);
    }

    private Account findAccount(Long id) throws NotExistincAccount {
        return this.accountRepository.findById(id).orElseThrow(NotExistincAccount::new);
    }
}
