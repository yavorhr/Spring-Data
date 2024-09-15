package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.BorrowingRecordDto;
import softuni.exam.models.dto.xml.BorrowingRecordsRootElement;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.service.BookService;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {
  private final static String RECORDS_FILE_PATH = "src/main/resources/files/xml/borrowing-records.xml";
  private final BorrowingRecordRepository borrowingRecordRepository;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;
  private final BookService bookService;
  private final LibraryMemberService libraryMemberService;
  private final ModelMapper modelMapper;

  public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, XmlParser xmlParser, ValidationUtil validationUtil, BookService bookService, LibraryMemberService libraryMemberService, ModelMapper modelMapper) {
    this.borrowingRecordRepository = borrowingRecordRepository;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
    this.bookService = bookService;
    this.libraryMemberService = libraryMemberService;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean areImported() {
    return this.borrowingRecordRepository.count() > 0;
  }

  @Override
  public String readBorrowingRecordsFromFile() throws IOException {
    return Files.readString(Path.of(RECORDS_FILE_PATH));
  }

  @Override
  public String importBorrowingRecords() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    BorrowingRecordsRootElement borrowingRecordsRootElement =
            this.xmlParser.fromFile(RECORDS_FILE_PATH, BorrowingRecordsRootElement.class);

    borrowingRecordsRootElement
            .getBorrowingRecords()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (findBookByTitle(dto.getBook().getTitle()).isEmpty() ||
                      findMemberById(dto.getMember().getId()).isEmpty()) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported borrowing record %s - %s",
                      dto.getBook().getTitle(),
                      dto.getBorrowDate())
                      : "Invalid borrowing record")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              BorrowingRecord entity = this.modelMapper.map(dto, BorrowingRecord.class);

              entity.setBook(findBookByTitle(dto.getBook().getTitle()).get());
              entity.setMember(findMemberById(dto.getMember().getId()).get());

              return entity;
            })
            .forEach(this.borrowingRecordRepository::save);

    return sb.toString().trim();
  }

  @Override
  public String exportBorrowingRecords() {
    return null;
  }

  // Helpers
  private Optional<Book> findBookByTitle(String title) {
    return this.bookService.findBookByTitle(title);
  }

  private Optional<LibraryMember> findMemberById(Long id) {
    return this.libraryMemberService.findById(id);
  }
}
