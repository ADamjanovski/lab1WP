package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class EventRepository {


    public List<Event> listAll() {
        return DataHolder.eventList;
    }

    public List<Event> searchEvents(String text) {
        return DataHolder.eventList.stream()
                .filter(event -> event.getName().contains(text) || event.getDescription().contains(text))
                .collect(Collectors.toList());
    }
}
