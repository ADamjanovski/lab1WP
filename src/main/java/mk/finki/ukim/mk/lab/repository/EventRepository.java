package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class EventRepository {


    public List<Event> listAll() {
        return DataHolder.eventList;
    }

    public List<Event> searchEvents(String text) {
        try{
            Double rating=Double.parseDouble(text);
            return DataHolder.eventList.stream()
                    .filter(event -> event.getPopularityScore()>=rating).collect(Collectors.toList());
        }catch (NumberFormatException e){
            return DataHolder.eventList.stream()
                    .filter(event -> event.getName().contains(text) || event.getDescription().contains(text))
                    .collect(Collectors.toList());
        }
    }
    public boolean delete(long id){
        return DataHolder.eventList.removeIf(location -> location.getId()==id);
    }
    public Event save(Event event){
        DataHolder.eventList.add(event);
        return event;
    }
    public Optional<Event> findById(long id){
        return DataHolder.eventList.stream().filter(event -> event.getId()==id).findFirst();
    }
    public Event update(long id, String name, String description, Location location){
        Event toUpdate= DataHolder.eventList.stream().filter(event -> event.getId()==id).findFirst().orElseThrow();
        toUpdate.setName(name);
        toUpdate.setDescription(description);
        toUpdate.setLocation(location);
        return toUpdate;
    }
}
