package com.example.demo_test.Services;

import com.example.demo_test.Exceptions.UserNotFoundException;
import com.example.demo_test.Exceptions.UsernameAlreadyExistsException;
import java.math.BigDecimal;

public interface UserService {

    void registerUser(String username, int age, BigDecimal initialAmount)
            throws UsernameAlreadyExistsException;

    void addAccount(BigDecimal amount, Long id) throws UserNotFoundException;

}
