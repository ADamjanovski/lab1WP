package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="EventBookingServlet" ,urlPatterns = "/eventBooking")
public class EventBookingServlet extends HttpServlet {
    private final EventBookingService eventBookingService;
    private final SpringTemplateEngine springTemplateEngine;

    public EventBookingServlet(EventBookingService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventBookingService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("ipAddress", req.getRemoteAddr());
        String queryString = req.getQueryString();
        if (queryString != null && !queryString.isEmpty()) {

            EventBooking booking=eventBookingService.placeBooking(req.getParameter("name"),req.getParameter("attendeeName"),req.getRemoteAddr(),Integer.parseInt(req.getParameter("numOfTickets")));
            context.setVariable("bookings",eventBookingService.searchByText(req.getParameter("attendeeName")));
            springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());

        } else {
            System.out.println("No query parameters found.");
        }
    }
}
