package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")

public class EventBookingController {
    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    private final EventBookingService eventBookingService;

    @GetMapping
    public String listBookings(HttpSession session, @RequestParam String name,@RequestParam String attendeeName, @RequestParam String numTickets,  Model model){
            EventBooking booking = eventBookingService.placeBooking
                    (name, attendeeName, (String) session.getAttribute("ipAddress"),
                            Integer.parseInt(numTickets));
            model.addAttribute("bookings",eventBookingService.searchByText(attendeeName));
            return "bookingConfirmation";

    }
}
