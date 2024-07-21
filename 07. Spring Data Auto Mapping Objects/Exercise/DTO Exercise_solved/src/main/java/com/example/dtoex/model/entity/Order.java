package com.example.dtoex.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private User buyer;
    private Set<Game> games;

    public Order() {
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    @ManyToMany
    public Set<Game> getGames() {
        return games;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
