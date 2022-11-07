package org.hibernate;
//POJO or Bean

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
    private String name;
    private String colour;
    @Id
    private int aid;

    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", aid=" + aid +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
