package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Dto.PostsRootSeedDto;
import softuni.exam.instagraphlite.models.Entity.Picture;
import softuni.exam.instagraphlite.models.Entity.Post;
import softuni.exam.instagraphlite.models.Entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final PictureService pictureService;
    private final UserService userService;

    private static final String POSTS_PATH_FILE = "src/main/resources/files/posts.xml";

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, PictureService pictureService, UserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
        this.userService = userService;
    }


    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_PATH_FILE));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PostsRootSeedDto postsRootSeedDto = xmlParser.fromFile(POSTS_PATH_FILE, PostsRootSeedDto.class);
     postsRootSeedDto.getPosts()
                .stream()
                .filter(postDetailsDto -> {
                    boolean isValid = validationUtil.isValid(postDetailsDto);

                    Picture byPath = pictureService.findByPath(postDetailsDto.getPicture().getPath());
                    User byUserName = userService.findByUserName(postDetailsDto.getUser().getUsername());

                    if (byPath == null || byUserName == null) {
                        isValid = false;
                    }

                    sb.append(isValid
                            ? String.format("Successfully imported post, made by %s", postDetailsDto.getUser().getUsername())
                            : "Invalid Post")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(postDetailsDto -> {
                    Post post = modelMapper.map(postDetailsDto, Post.class);
                    String username = postDetailsDto.getUser().getUsername();
                    String path = postDetailsDto.getPicture().getPath();

                    Picture picture = pictureService.findByPath(path);
                    User user = userService.findByUserName(postDetailsDto.getUser().getUsername());

                    post.setUser(user);
                    post.setPicture(picture);

                    return post;
                })
         .forEach(postRepository::save);


        return sb.toString();
    }
}
