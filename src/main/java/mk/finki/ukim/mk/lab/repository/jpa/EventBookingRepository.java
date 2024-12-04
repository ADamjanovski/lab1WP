package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {
    List<EventBooking> findByAttendee(User attendee);
}
