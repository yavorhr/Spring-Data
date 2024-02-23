package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Dto.UsersSeedDto;
import softuni.exam.instagraphlite.models.Entity.Picture;
import softuni.exam.instagraphlite.models.Entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final PictureService pictureService;

    private static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper, PictureService pictureService) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;

        this.pictureService = pictureService;
    }


    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        UsersSeedDto[] usersSeedDtos = gson.fromJson(readFromFileContent(), UsersSeedDto[].class);

        System.out.println();
        Arrays.stream(usersSeedDtos)
                .filter(usersSeedDto -> {
                    boolean isValid = validationUtil.isValid(usersSeedDto);

                    Picture picture = pictureService.findByPath(usersSeedDto.getProfilePicture());

                    if (picture == null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported User: %s", usersSeedDto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(usersSeedDto -> {

                    User user = modelMapper.map(usersSeedDto, User.class);
                    user.setProfilePicture(pictureService.findByPath(usersSeedDto.getProfilePicture()));

                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        List<User> users = userRepository.findAllUsersOrderedByPostsCountDescThenById();

        for (User user : users) {
            sb.append(String.format("User: %s\n" +
                            "Post count: %d\n"
                    , user.getUsername(), user.getPosts().size()));
            user
                    .getPosts()
                    .stream()
                    .sorted(Comparator.comparingDouble(p -> p.getPicture().getSize()))
                    .forEach(p -> sb.append(String.format("" +
                                    "==Post Details:" +
                                    "----Caption: %s\n" +
                                    "----Picture Size: %.2f"
                            , p.getCaption(),
                            p.getPicture().getSize()))
                            .append(System.lineSeparator()));
        }

        return sb.toString();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }


}
