package softuni.exam.instagraphlite.models.Dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsRootSeedDto {

    @XmlElement(name = "post")
    private List<PostDetailsDto> posts;

    public List<PostDetailsDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDetailsDto> posts) {
        this.posts = posts;
    }
}
