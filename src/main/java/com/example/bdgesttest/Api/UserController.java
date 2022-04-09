package com.example.bdgesttest.Api;

import com.example.bdgesttest.Service.UserService;
import com.example.bdgesttest.persistence.Album;
import com.example.bdgesttest.persistence.Contributor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/api/addUser")
    public void addUser(String login, String password, String role, ArrayList<Album> albumsList) {
        logger.info("Service addUser");
        userService.addUser(login, password, role, albumsList);
    }

}
