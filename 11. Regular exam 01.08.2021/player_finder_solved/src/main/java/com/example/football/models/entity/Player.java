package com.example.football.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Position position;
    private Team team;
    private Town town;
    private Stat stat;

    public Player() {
    }

    @ManyToOne
    public Team getTeam() {
        return team;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    @ManyToOne
    public Stat getStat() {
        return stat;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    @Column(name = "birth_date", nullable = false)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "position", nullable = false)
    public Position getPosition() {
        return position;
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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
