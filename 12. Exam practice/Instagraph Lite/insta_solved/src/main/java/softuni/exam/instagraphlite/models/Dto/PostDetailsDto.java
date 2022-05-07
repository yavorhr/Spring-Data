package softuni.exam.instagraphlite.models.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostDetailsDto {

    @XmlElement(name = "caption")
    private String caption;

    @XmlElement(name = "user")
    private UserSeedDtoXml user;
    @XmlElement(name = "picture")
    private PictureSeedDtoXml picture;

    @NotBlank
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    @NotNull
    public UserSeedDtoXml getUser() {
        return user;
    }

    public void setUser(UserSeedDtoXml user) {
        this.user = user;
    }

    @NotNull
    public PictureSeedDtoXml getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedDtoXml picture) {
        this.picture = picture;
    }
}
