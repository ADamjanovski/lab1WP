package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Event> eventList;
    public static List<EventBooking> eventBookings;

    @PostConstruct
    public void init(){
        eventList = new ArrayList<>();
        eventList.add(new Event("Web Prog","Predavanja",5));
        eventList.add(new Event("Parallel Prog","Predavanja",5));
        eventList.add(new Event("Halloween Party","The best halloween party ",10));
        eventList.add(new Event("Conference","Held at Marriot hotel Skopje",7));
        eventList.add(new Event("Adam's Birthday Party","Party for my 20th birthday",9));
        eventList.add(new Event("Eclipse Coffee","Grand Opening",6));
        eventList.add(new Event("Election Day","Election day for parliament",5));
        eventList.add(new Event("Drake","The biggest concert in the country",9));
        eventList.add(new Event("The weeknd album release","Album release by the biggest pop artist",10));
        eventList.add(new Event("Champions League final","El clasico in the biggest game in the world",10));
        eventBookings=new ArrayList<>();
    }

    public List<Event> getEventList() {
        return eventList;
    }
}
