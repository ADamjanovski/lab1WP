package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.EventBooking;

import java.util.List;

public interface EventBookingService {
    EventBooking placeBooking(Long eventId, String attendeeName, String attendeeAddress, int numberOfTickets);
    List<EventBooking> searchByText(String text);
}
