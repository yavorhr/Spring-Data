package com.example.football.models.dto.xml.playerDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerDetailsDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "town")
    private TownWithNameDto town;
    @XmlElement(name = "team")
    private TeamNameDto team;
    @XmlElement(name = "stat")
    private StatIdDto stat;

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }
    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }
    @Email
    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public TownWithNameDto getTown() {
        return town;
    }

    public TeamNameDto getTeam() {
        return team;
    }

    public StatIdDto getStat() {
        return stat;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTown(TownWithNameDto town) {
        this.town = town;
    }

    public void setTeam(TeamNameDto team) {
        this.team = team;
    }

    public void setStat(StatIdDto stat) {
        this.stat = stat;
    }
}
