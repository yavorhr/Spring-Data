package softuni.exam.service;

import softuni.exam.models.entity.LibraryMember;

import java.io.IOException;
import java.util.Optional;

public interface LibraryMemberService {

    boolean areImported();

    String readLibraryMembersFileContent() throws IOException;
	
	String importLibraryMembers() throws IOException;

	Optional<LibraryMember> findById(Long id);
}
