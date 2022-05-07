package softuni.exam.models.Dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.Entity.Town;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PassengersInputDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private String phoneNumber;
    @Expose
    private String email;
    @Expose
    private String town;

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }
    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }
    @Positive
    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public String getTown() {
        return town;
    }
}
