package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    private String name;
    private String stadiumName;
    private int fanBase;
    private String history;
    private Town town;

    public Team() {
    }


    // TODO: 8/1/2021 optional false ?
    @ManyToOne
    public Town getTown() {
        return town;
    }

    @Column(name = "name",unique = true,nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "stadium_name",nullable = false)
    public String getStadiumName() {
        return stadiumName;
    }
    @Column(name = "fan_base",nullable = false)
    public int getFanBase() {
        return fanBase;
    }
    @Column(name = "history",columnDefinition = "TEXT",nullable = false)
    public String getHistory() {
        return history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setFanBase(int fanBase) {
        this.fanBase = fanBase;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
