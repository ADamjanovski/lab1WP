package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exception.UserNotFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String firstName, String lastName,String ipAddress,Role role) {
        return userRepository.save(new User(username,passwordEncoder.encode(password),firstName,lastName,ipAddress,role));
    }

    @Override
    public User loadUserByUsername(String username) throws UserNotFoundException {
        return userRepository.findById(username).orElseThrow(() -> new UserNotFoundException("User not found"));

    }
}
