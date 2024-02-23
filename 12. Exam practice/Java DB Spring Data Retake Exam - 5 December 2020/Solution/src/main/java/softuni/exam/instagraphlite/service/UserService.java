package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.Entity.User;

import java.io.IOException;

public interface UserService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importUsers() throws IOException;
    String exportUsersWithTheirPosts();


    User findByUserName(String username);
}
