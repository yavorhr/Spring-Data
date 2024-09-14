package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.LibraryMemberService;

import java.io.IOException;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readLibraryMembersFileContent() throws IOException {
    return null;
  }

  @Override
  public String importLibraryMembers() throws IOException {
    return null;
  }
}
