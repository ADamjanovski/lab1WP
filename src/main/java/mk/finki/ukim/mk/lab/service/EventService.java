package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    public boolean delete(long id);
    public Event save(Event event);
    public Optional<Event> findById(long id);
    public Event update(long id, String name, String description, Location location);
}
