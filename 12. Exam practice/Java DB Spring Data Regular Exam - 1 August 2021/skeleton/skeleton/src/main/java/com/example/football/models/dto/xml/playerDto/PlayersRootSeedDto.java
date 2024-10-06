package com.example.football.models.dto.xml.playerDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayersRootSeedDto {

    @XmlElement(name = "player")
    List<PlayerDetailsDto> players;

    public List<PlayerDetailsDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDetailsDto> players) {
        this.players = players;
    }
}
