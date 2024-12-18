package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.ListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = {"/events","/",""})
public class EventController {
    public final ListService listService;

    public EventController(ListService listService, EventService eventService) {
        this.listService = listService;
        this.eventService = eventService;
    }

    public final EventService eventService;

    @GetMapping
    public String getEventsPage(@RequestParam(required=false) String error,@RequestParam(required=false) String search, Model model){
        if(error!=null){
            model.addAttribute("hasError" ,true);
            model.addAttribute("errorMessage",error);
        }
        if(search!=null && !search.isEmpty()){
            model.addAttribute("events",eventService.searchEvents(search));
        }else {
            model.addAttribute("events", eventService.listAll());
        }
        return "listEvents";
    }
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable long id){
        if(eventService.delete(id))
            return "redirect:/events";
        return "redirect:/events?error=No Event found";
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveEvent(@RequestParam String name,@RequestParam String description,@RequestParam double popularityScore,@RequestParam long locationId){
        Event event=new Event(name,description,popularityScore,listService.findById(locationId));
        eventService.save(event);
        return "redirect:/events";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editEvent(@PathVariable long id,@RequestParam String name,@RequestParam String description,@RequestParam long locationId){
        Location location=listService.findById(locationId);
        eventService.update(id,name,description,location);
        return "redirect:/events";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable long id, Model model){
        if(eventService.findById(id).isPresent()){
            Event event=eventService.findById(id).get();
            List<Location> locationList=listService.findAll();
            model.addAttribute("event",event);
            model.addAttribute("locations",locationList);
            return "add-event";
        }
        return "redirect:/events?error=NoEventFound";
    }
    @GetMapping("/add-form")
    public String getAddEventForm(Model model){
        List<Location> locationList=listService.findAll();
        model.addAttribute("locations",locationList);
        return "add-event";
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public String BookEvent( @RequestParam Long id, @RequestParam String numTickets){
        return "redirect:/eventBooking?id="+id+"&numTickets="+numTickets;
    }
    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        return "access-denied";
    }
    @GetMapping("/add-location-form")
    public String getAddLocationForm(){
        return "addLocation";
    }

    @PreAuthorize("hasRole('ADMIN')")

    @PostMapping("/add-location")
    public String addLocation(@RequestParam String name,@RequestParam String address,@RequestParam String capacity,@RequestParam String description){
        listService.save(new Location(name,address,capacity,description));
        return "redirect:/events";
    }
}
