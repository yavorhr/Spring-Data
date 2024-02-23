package softuni.exam.instagraphlite.models.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.exam.instagraphlite.models.Entity.Picture;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsersSeedDto {

    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String profilePicture;

    @NotNull
    @Column(unique = true)
    @Size(min = 2,max = 18)
    public String getUsername() {
        return username;
    }

    @NotNull
    @Size(min = 4)
    public String getPassword() {
        return password;
    }

    @SerializedName("profilePicture")
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
