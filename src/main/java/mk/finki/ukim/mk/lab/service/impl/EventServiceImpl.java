package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {
    public final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        try{
            Double rating=Double.parseDouble(text);
            return eventRepository.findByPopularityScoreIsGreaterThanEqual(rating);
        }catch (NumberFormatException e){
            return eventRepository.findByNameLikeOrDescriptionLike(text,text);
        }
    }

    @Override
    public boolean delete(long id) {
        return eventRepository.deleteById(id);
    }

    @Override
    public Event save(Event event) {

        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event update(long id, String name, String description, Location location) {
        if(eventRepository.findById(id).isPresent()) {
            double popularityScore=eventRepository.findById(id).get().getPopularityScore();
            eventRepository.deleteById(id);

            return eventRepository.save(new Event(name,description,popularityScore,location));
        }
        return null;
    }
}
