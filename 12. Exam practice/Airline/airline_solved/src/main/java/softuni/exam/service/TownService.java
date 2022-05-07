package softuni.exam.service;

import softuni.exam.models.Entity.Town;
import java.io.IOException;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

	Town findTownByName(String name);

    Town findToTownByName(String name);
}
