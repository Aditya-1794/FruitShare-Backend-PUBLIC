package com.FruitDistribution.FruitDistribution_API.controller;

import com.FruitDistribution.FruitDistribution_API.domain.User;
import com.FruitDistribution.FruitDistribution_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable String id) {
        return service.findUserById(id);
    }
}
