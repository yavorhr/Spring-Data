package softuni.exam.instagraphlite.models.Dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureSeedDtoXml {

    @XmlElement(name = "path")
    private String path;

    @NotNull
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
