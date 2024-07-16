package com.FruitDistribution.FruitDistribution_API.controller;

import com.FruitDistribution.FruitDistribution_API.domain.User;
import com.FruitDistribution.FruitDistribution_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/findUserById/{userId}")
    public User findUserById(@PathVariable String userId) {
        return service.findUserById(userId);
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody User req) {
        return service.addNewUser(req);
    }

    @DeleteMapping("deleteUser/{userId}")
    public void deleteUser(@PathVariable User u) {
        service.deleteUser(u);
    }

    @DeleteMapping("deleteAllUsers")
    public void deleteAllUsers() {
        service.deleteAllUsers();
    }
}
