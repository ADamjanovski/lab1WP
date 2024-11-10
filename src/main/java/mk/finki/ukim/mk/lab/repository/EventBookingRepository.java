package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventBookingRepository {
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking booking= new EventBooking(eventName,attendeeName,attendeeAddress,numberOfTickets);
        DataHolder.eventBookings.add(booking);
        return booking;
    }
    public List<EventBooking> searchByText(String text) {
        return DataHolder.eventBookings.stream()
                .filter(booking -> booking.getAttendeeName().equals(text)).collect(Collectors.toList());
    }
}
