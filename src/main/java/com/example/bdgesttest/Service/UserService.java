package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String login, String password, String role, List<Album> albumsList) {
        if (!userRepository.existsById(login)) {
            userRepository.save(new User(login, password, role, albumsList));
        }
    }

}
