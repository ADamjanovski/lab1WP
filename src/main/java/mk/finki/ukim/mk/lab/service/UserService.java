package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.User;


public interface UserService {
    User save(String username,String password ,String firstName,String lastName,String ipAddress);
    User findById(String username);
}
