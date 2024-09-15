package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.MemberSeedDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {
  private static final String LIB_MEMBERS_FILE_PATH = "src/main/resources/files/json/library-members.json";
  private final LibraryMemberRepository libraryMemberRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;

  public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
    this.libraryMemberRepository = libraryMemberRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
  }

  @Override
  public boolean areImported() {
    return this.libraryMemberRepository.count() > 0;
  }

  @Override
  public String readLibraryMembersFileContent() throws IOException {
    return Files.readString(Path.of(LIB_MEMBERS_FILE_PATH));
  }

  @Override
  public String importLibraryMembers() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readLibraryMembersFileContent(), MemberSeedDto[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (this.libraryMemberRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent()) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported library member %s - %s", dto.getFirstName(), dto.getLastName())
                      : "Invalid library member")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> this.modelMapper.map(dto, LibraryMember.class))
            .forEach(this.libraryMemberRepository::save);

    return sb.toString();
  }
}
