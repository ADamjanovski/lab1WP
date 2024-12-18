package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String name, String description);
    List<Event> findByPopularityScoreIsGreaterThanEqual(double rating);
    Event findByName(String name);
}
