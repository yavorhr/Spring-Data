package softuni.exam.service;

import softuni.exam.models.entity.Star;

import java.io.IOException;

// TODO: Implement all methods
public interface StarService {

    boolean areImported();

    String readStarsFileContent() throws IOException;
	
	String importStars() throws IOException;

    String exportStars();

    Star findStarById(Long id);
}
