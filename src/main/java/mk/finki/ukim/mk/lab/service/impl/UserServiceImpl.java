package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(String username, String password, String firstName, String lastName,String ipAddress) {
        return userRepository.save(new User(username,password,firstName,lastName,ipAddress));
    }

    @Override
    public User findById(String username) {
        return userRepository.findById(username).get();
    }
}
