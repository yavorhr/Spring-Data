package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.Entity.Picture;

import java.io.IOException;

public interface PictureService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

    Picture findByPath(String path);
}
