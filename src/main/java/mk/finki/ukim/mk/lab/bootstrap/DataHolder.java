package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Event> eventList;
    @PostConstruct
    public void init(){
        eventList = new ArrayList<>();
        eventList.add(new Event("Web Prog","Predavanja",8));
        eventList.add(new Event("Parallel Prog","Predavanja",9));
        eventList.add(new Event("Halloween Party","The best halloween party ",10));
        eventList.add(new Event("IEEE Conference","Held at Marriot hotel Skopje",7));
        eventList.add(new Event("Adam's Birthday Party","Party for my 20th birthday",9));
        eventList.add(new Event("Eclipse Coffee","Grand Opening",6));
        eventList.add(new Event("Election Day","Election day for parliament",5));
        eventList.add(new Event("Dino Merlin Concert","The biggest concert in the country",9));
        eventList.add(new Event("The weeknd album release","Album release by the biggest pop artist",10));
        eventList.add(new Event("Champions League final","El clasico in the biggest game in the world",10));

    }

    public List<Event> getEventList() {
        return eventList;
    }
}
