package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsRootSeedDto {

    @XmlElement(name = "stat")
    private List<StatDetailsDto> stats;

    public List<StatDetailsDto> getStats() {
        return stats;
    }

    public void setStats(List<StatDetailsDto> stats) {
        this.stats = stats;
    }
}
