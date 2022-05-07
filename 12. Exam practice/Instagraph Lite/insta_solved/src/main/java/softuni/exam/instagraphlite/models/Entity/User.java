package softuni.exam.instagraphlite.models.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private Picture profilePicture;

    private Set<Post> posts;

    @OneToMany(mappedBy = "user")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public User() {
    }

    @Column(name = "username", nullable = false, unique = true, length = 18)
    public String getUsername() {
        return username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @ManyToOne
    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }
}
