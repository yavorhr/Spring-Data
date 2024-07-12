package com.example.demo_test.Services.Impl;

import com.example.demo_test.Exceptions.UserNotFoundException;
import com.example.demo_test.Exceptions.UsernameAlreadyExistsException;
import com.example.demo_test.Models.Account;
import com.example.demo_test.Models.User;
import com.example.demo_test.Repositories.AccountRepository;
import com.example.demo_test.Repositories.UserRepository;
import com.example.demo_test.Services.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException {

        if (this.userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }

        User user = new User();
        user.setAge(age);
        user.setUsername(username);

        this.userRepository.save(user);

       this.saveAccount(initialAmount,user);
    }

    @Override
    public void addAccount(BigDecimal amount, Long id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        this.saveAccount(amount, user);
    }

    private void saveAccount(BigDecimal amount, User user) {
        Account account = new Account();
        account.setBalance(amount);
        account.setUser(user);
        this.accountRepository.save(account);
    }
}
