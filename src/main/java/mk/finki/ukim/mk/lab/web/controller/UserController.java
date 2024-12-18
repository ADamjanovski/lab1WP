package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")

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
    public String loginPost(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName,HttpSession session,HttpServletRequest request){

        session.setAttribute("user",userService.register(username,password,firstName,lastName, request.getRemoteAddr(), Role.ROLE_USER));
        return "redirect:/events";
    }

}
