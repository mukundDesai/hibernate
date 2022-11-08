package org.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Planet {
    @Id
    private int planet_no;
    private String name;
    private String climate;
    @OneToMany(mappedBy = "planet")
    private List<Alien> aliens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public int getPlanet_no() {
        return planet_no;
    }

    public void setPlanet_no(int planet_no) {
        this.planet_no = planet_no;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planet_no=" + planet_no +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", aliens=" + aliens +
                '}';
    }
}
