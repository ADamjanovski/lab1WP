package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exception.UserNotFoundException;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")

public class EventBookingController {
    public EventBookingController(EventBookingService eventBookingService, UserService userService) {
        this.eventBookingService = eventBookingService;
        this.userService = userService;
    }

    private final EventBookingService eventBookingService;
    private final UserService userService;

    @GetMapping
    public String listBookings(HttpSession session,HttpServletRequest req, @RequestParam Long id , @RequestParam String numTickets,  Model model){
        //User user=(User) session.getAttribute("user");
        try{
            User user=userService.loadUserByUsername(req.getRemoteUser());
        }catch (UserNotFoundException e){
            User user=userService.register(req.getRemoteUser(),"SomethingStupidToWorkWithInMemUser",null,null,req.getRemoteAddr(), Role.ROLE_USER);
        }
        EventBooking booking = eventBookingService.placeBooking
                    (id,req.getRemoteUser() , req.getRemoteAddr(),
                            Integer.parseInt(numTickets));
            model.addAttribute("bookings",eventBookingService.searchByText(req.getRemoteUser()));
            return "bookingConfirmation";

    }
}
