package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")

public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginPage(HttpServletRequest request, @RequestParam(required=false) String error, Model model){
        return "inputName";
    }

    @PostMapping
    public String loginPost(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, HttpSession session,HttpServletRequest request){

        session.setAttribute("user",userService.save(username,password,firstName,lastName, request.getRemoteAddr()));
        return "redirect:/events";
    }

}
