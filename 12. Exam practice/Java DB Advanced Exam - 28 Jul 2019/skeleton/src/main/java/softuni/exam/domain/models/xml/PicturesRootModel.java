package softuni.exam.domain.models.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PicturesRootModel {

  @XmlElement(name = "picture")
  private List<PictureDetailsModel> pictures;

  public PicturesRootModel() {
  }

  public List<PictureDetailsModel> getPictures() {
    return pictures;
  }

  public PicturesRootModel setPictures(List<PictureDetailsModel> pictures) {
    this.pictures = pictures;
    return this;
  }
}
