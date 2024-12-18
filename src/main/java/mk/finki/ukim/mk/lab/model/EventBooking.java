package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
public class EventBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Event event;
    @ManyToOne
    private User attendee;
    private String attendeeAddress;
    private long numberOfTickets;

    public EventBooking(Event event, User attendee,
                        String attendeeAddress, long numberOfTickets) {
        this.event = event;
        this.attendee = attendee;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }


}
