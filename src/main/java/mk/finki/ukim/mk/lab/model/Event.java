package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.Random;

@Data
public class Event {
    private long id;
    private String name;
    private String description;
    private double popularityScore;
    private Location location;
    public Event(String name, String description, double popularityScore,Location location) {
        id= (long) (Math.random()*1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public Location getLocation() {
        return location;
    }

    public long getId() {
        return id;
    }
}
