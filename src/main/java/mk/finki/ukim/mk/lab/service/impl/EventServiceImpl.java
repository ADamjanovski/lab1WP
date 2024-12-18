package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventBookingRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {
    public final EventRepository eventRepository;
    public final EventBookingRepository eventBookingRepository;

    public EventServiceImpl(EventRepository eventRepository, EventBookingRepository eventBookingRepository) {
        this.eventRepository = eventRepository;
        this.eventBookingRepository = eventBookingRepository;
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
            return eventRepository.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(text,text);
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        try {
            eventBookingRepository.deleteAllByEvent_Id(id);
            eventRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
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
            Event event=eventRepository.findById(id).get();
            event.setLocation(location);
            event.setDescription(description);
            event.setName(name);
//            double popularityScore=eventRepository.findById(id).get().getPopularityScore();
//            eventRepository.deleteById(id);
            return eventRepository.save(event);
//            return eventRepository.save(new Event(name,description,popularityScore,location));
        }
        return null;
    }
}
