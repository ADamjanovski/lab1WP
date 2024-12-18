package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService {
    User register(String username, String password, String firstName, String lastName,String ipAddress,Role role);
    User loadUserByUsername(String username) throws UserNotFoundException;
}
