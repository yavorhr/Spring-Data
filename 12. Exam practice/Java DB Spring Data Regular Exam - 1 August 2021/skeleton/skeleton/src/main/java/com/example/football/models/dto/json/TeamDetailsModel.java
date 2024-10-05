package com.example.football.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamDetailsModel {

    @Expose
    private String name;
    @Expose
    private String stadiumName;
    @Expose
    private int fanBase;
    @Expose
    private String history;
    @Expose
    private String townName;

    @Size(min = 3)
    @NotBlank
    public String getName() {
        return name;
    }

    @Size(min = 3)
    @NotNull
    public String getStadiumName() {
        return stadiumName;
    }

    @Min(1000)
    public int getFanBase() {
        return fanBase;
    }

    @Size(min = 10)
    public String getHistory() {
        return history;
    }

    public String getTownName() {
        return townName;
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

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
