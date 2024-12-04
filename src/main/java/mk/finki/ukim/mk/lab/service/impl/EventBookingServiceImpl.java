package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.jpa.EventBookingRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    public final EventBookingRepository eventBookingRepository;
    public final EventRepository eventRepository;
    public final UserRepository userRepository;
    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public EventBooking placeBooking(Long eventId, String attendeeName, String attendeeAddress, int numberOfTickets) {
        Event event=eventRepository.findById(eventId).get();
        User user=userRepository.findById(attendeeName).get();
        return eventBookingRepository
                .save(new EventBooking(event,user,attendeeAddress,numberOfTickets));
    }

    @Override
    public List<EventBooking> searchByText(String text) {
        return eventBookingRepository.findByAttendee(userRepository.findById(text).get());
    }
}
