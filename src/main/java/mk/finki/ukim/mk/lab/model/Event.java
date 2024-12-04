package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double popularityScore;
    @ManyToOne()
    private Location location;
    @OneToMany(mappedBy = "event")
    @ToString.Exclude
    private List<EventBooking> bookings;
    public Event(String name, String description, double popularityScore,Location location) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location=location;
    }



}
