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
        List<String> values = new ArrayList<>();
        if (queryString != null && !queryString.isEmpty()) {
            String[] params = queryString.split("&");

            for (String param : params) {
                String[] keyValue = param.split("=", 2);
                String key = keyValue[0];
                String value = keyValue.length > 1 ?  URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8) : "";
                System.out.println("Key: " + key + ", Value: " + value);
                values.add(value);
            }
            EventBooking booking=eventBookingService.placeBooking(values.get(0),values.get(1),req.getRemoteAddr(),Integer.parseInt(values.get(2)));
            context.setVariable("booking",booking);
            springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());

        } else {
            System.out.println("No query parameters found.");
        }
    }
}
