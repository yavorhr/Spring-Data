package softuni.exam.models.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordsRootElement {

  @XmlElement(name = "borrowing_record")
  List<BorrowingRecordDto> borrowingRecords;

  public List<BorrowingRecordDto> getBorrowingRecords() {
    return borrowingRecords;
  }

  public void setBorrowingRecords(List<BorrowingRecordDto> borrowingRecords) {
    this.borrowingRecords = borrowingRecords;
  }
}
