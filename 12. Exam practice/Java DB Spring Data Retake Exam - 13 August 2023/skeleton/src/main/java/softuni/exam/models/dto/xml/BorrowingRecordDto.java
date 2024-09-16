package softuni.exam.models.dto.xml;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordDto {
  @XmlElement(name = "borrow_date")
  private String borrowDate;
  @XmlElement(name = "return_date")
  private String returnDate;
  @XmlElement(name = "remarks")
  private String remarks;
  @XmlElement(name = "book")
  private BookDto book;
  @XmlElement(name = "member")
  private MemberDto member;

  public BorrowingRecordDto() {
  }

  @NotNull
  public String getBorrowDate() {
    return borrowDate;
  }

  @NotNull
  public String getReturnDate() {
    return returnDate;
  }

  @Size(min = 3,max = 100)
  public String getRemarks() {
    return remarks;
  }

  @NotNull
  public BookDto getBook() {
    return book;
  }

  @NotNull
  public MemberDto getMember() {
    return member;
  }

  public void setBorrowDate(String borrowDate) {
    this.borrowDate = borrowDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public void setBook(BookDto book) {
    this.book = book;
  }

  public void setMember(MemberDto member) {
    this.member = member;
  }
}
