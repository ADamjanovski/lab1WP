package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Event> eventList;
    public static List<EventBooking> eventBookings;

    public static List<Location> locations;
    @PostConstruct
    public void init(){
        locations=new ArrayList<>();
        eventList = new ArrayList<>();
        locations.add(new Location("East Gate","Skopje 123","4000","Shopping mall"));
        locations.add(new Location("Finki","Karpos 2","6000","Faculty"));
        locations.add(new Location("Dabov","Tavtalidje","20","Coffee shop"));
        locations.add(new Location("Stadion Tose Proeski","Gradski Park","20000","National football stadium"));
        locations.add(new Location("Sub Club","Strumica","500","Bar"));
        eventList.add(new Event("Web Prog","Predavanja",5,locations.get(1)));
        eventList.add(new Event("Parallel Prog","Predavanja",5,locations.get(1)));
        eventList.add(new Event("Halloween Party","The best halloween party ",10,locations.get(4)));
        eventList.add(new Event("Conference","International conference",8,locations.get(0)));
        eventList.add(new Event("Adam's Birthday Party","Party for my 20th birthday",9,locations.get(4)));
        eventList.add(new Event("Coffee making class","Learn about cofee",6,locations.get(2)));
        eventList.add(new Event("Election Day","Election day for parliament",5,locations.get(3)));
        eventList.add(new Event("Drake","The biggest concert in the country",9,locations.get(3)));
        eventList.add(new Event("The weeknd album release","Album release by the biggest pop artist",10,locations.get(3)));
        eventList.add(new Event("Champions League final","El clasico in the biggest game in the world",10,locations.get(3)));
        eventBookings=new ArrayList<>();
    }

    public List<Event> getEventList() {
        return eventList;
    }
}
