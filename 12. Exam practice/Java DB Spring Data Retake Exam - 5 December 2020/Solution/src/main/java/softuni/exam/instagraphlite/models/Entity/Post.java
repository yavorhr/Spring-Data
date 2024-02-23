package softuni.exam.instagraphlite.models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    private String caption;
    private User user;
    private Picture picture;

    public Post() {
    }

    @Column(name = "caption",nullable = false)
    public String getCaption() {
        return caption;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    @ManyToOne
    public Picture getPicture() {
        return picture;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
