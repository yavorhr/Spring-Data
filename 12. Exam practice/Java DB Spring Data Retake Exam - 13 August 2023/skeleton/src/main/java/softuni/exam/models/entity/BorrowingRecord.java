package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "borrowing_records")
public class BorrowingRecord extends BaseEntity {
  private LocalDate borrowDate;
  private String remarks;
  private LocalDate returnDate;
  private Book book;
  private LibraryMember member;

  public BorrowingRecord() {
  }

  @Column(name = "borrow_date", columnDefinition = "DATE", nullable = false)
  public LocalDate getBorrowDate() {
    return borrowDate;
  }

  @Column
  public String getRemarks() {
    return remarks;
  }

  @Column(name = "return_date", columnDefinition = "DATE", nullable = false)
  public LocalDate getReturnDate() {
    return returnDate;
  }

  @ManyToOne
  public Book getBook() {
    return book;
  }

  @ManyToOne
  public LibraryMember getMember() {
    return member;
  }

  public void setBorrowDate(LocalDate borrowDate) {
    this.borrowDate = borrowDate;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public void setMember(LibraryMember member) {
    this.member = member;
  }
}
