package softuni.exam.service;

import softuni.exam.models.entity.Part;

import java.io.IOException;

public interface PartService {

  boolean areImported();

  String readPartsFileContent() throws IOException;

  String importParts() throws IOException;

  Part findPartById(Long id);
}
