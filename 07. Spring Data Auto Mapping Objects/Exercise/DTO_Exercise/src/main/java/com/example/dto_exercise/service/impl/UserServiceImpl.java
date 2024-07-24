package com.example.dto_exercise.service.impl;

import com.example.dto_exercise.model.dto.UserLoginDto;
import com.example.dto_exercise.model.dto.UserRegisterDto;
import com.example.dto_exercise.model.dto.ViewGameDetailsDto;
import com.example.dto_exercise.model.entity.User;
import com.example.dto_exercise.repository.UserRepository;
import com.example.dto_exercise.service.UserService;
import com.example.dto_exercise.userContext.UserContext;
import com.example.dto_exercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;
  private final UserRepository userRepository;
  private final UserContext userContext;

  public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, UserRepository userRepository, UserContext userContext) {
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
    this.userRepository = userRepository;
    this.userContext = userContext;
  }

  @Override
  public void registerUser(UserRegisterDto userRegisterDto) {
    if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmedPassword())) {
      System.out.println("Password and Confirm password doesn't match!");
      return;
    }

    if (this.userRepository.findUserByEmail(userRegisterDto.getEmail()).isPresent()){
      System.out.printf("User with %s is already existing!", userRegisterDto.getEmail());
      return;
    }

    Set<ConstraintViolation<UserRegisterDto>> violation =
            validationUtil.violation(userRegisterDto);

    if (!violation.isEmpty()) {
      violation
              .stream()
              .map(ConstraintViolation::getMessage)
              .forEach(System.out::println);
      return;
    }

    User user = this.modelMapper.map(userRegisterDto, User.class);
    if (this.userRepository.countAdmins() == 0) {
      user.setAdmin(true);
    }

    this.userRepository.save(user);
    System.out.printf("%s was registered%n", user.getFullName());
  }

  @Override
  public void loginUser(UserLoginDto userLoginDto) {
    Set<ConstraintViolation<UserLoginDto>> violation =
            this.validationUtil.violation(userLoginDto);

    if (!violation.isEmpty()) {
      violation
              .stream()
              .map(ConstraintViolation::getMessage)
              .forEach(System.out::println);
      return;
    }

    String email = userLoginDto.getEmail();
    String password = userLoginDto.getPassword();

    if (!doesUserExistByEmail(email) || !doesUserExistByEmailAndPassword(email, password)) {
      return;
    }

    User user = getUser(email, password);

    this.userContext.saveSession(
            user.getId(),
            user.getEmail(),
            user.getFullName(),
            user.getPassword(),
            user.isAdmin());

    System.out.printf("Successfully logged in %s%n", user.getFullName());
  }

  @Override
  public void logout() {
    if (this.userContext.getId() == 0) {
      System.out.println("Cannot log out. No user was logged in.");
      return;
    }

    System.out.printf("User %s successfully logged out\n", this.userContext.getFullName());
    this.userContext.removeSession();
  }

  @Override
  public void printGamesByUserId() {
    if (userContext.getId() == null) {
      System.out.println("There is no logged in user currently!");
    }

    User user = this.userRepository
            .findById(this.userContext.getId())
            .orElse(null);

    if (user.getGames().isEmpty()) {
      System.out.println("User has no games added!");
      return;
    }

    List<ViewGameDetailsDto> games =
            this.modelMapper.map(
                    user.getGames(),
                    new TypeToken<List<ViewGameDetailsDto>>() {
                    }.getType());

    games.forEach(g -> System.out.println(g.getTitle()));

  }

  @Override
  public void deleteUser(long userId) {
    if (this.userContext.getId() == null || !this.userContext.isAdmin()) {
      System.out.println("Only logged in admins are allowed to delete users!");
      return;
    }

    String email = this.userRepository.findById(userId).orElse(null).getEmail();

    if (this.userContext.getId() == userId) {
      System.out.println("Admin can't be deleted!");
      return;
    }

    this.userRepository.deleteById(userId);
    System.out.printf("User with %s was removed!\n", email);
  }

  // Helpers
  private boolean doesUserExistByEmailAndPassword(String email, String password) {
    User user = getUser(email, password);

    if (user == null) {
      System.out.println("Email or password doesn't match!");
      return false;
    }

    return true;
  }

  private boolean doesUserExistByEmail(String email) {
    User user = this.userRepository.findUserByEmail(email).orElse(null);

    if (user == null) {
      System.out.println("Email with this email does not exist!");
      return false;
    }

    return true;
  }

  public User getUser(String email, String password) {
    return this.userRepository
            .findUserByEmailAndPassword(
                    email,
                    password)
            .orElse(null);
  }
}
