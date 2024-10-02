package exam.model.service.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopsRootModel {

  List<ShopDetailsModel> shops;

  public List<ShopDetailsModel> getShops() {
    return shops;
  }

  public ShopsRootModel setShops(List<ShopDetailsModel> shops) {
    this.shops = shops;
    return this;
  }
}
