package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByNameLikeOrDescriptionLike(String name, String description);
    List<Event> findByPopularityScoreIsGreaterThanEqual(double rating);
    boolean deleteById(long id);
    Event findByName(String name);
}
