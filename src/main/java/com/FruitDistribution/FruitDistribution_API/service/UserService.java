package com.FruitDistribution.FruitDistribution_API.service;

import com.FruitDistribution.FruitDistribution_API.domain.User;
import com.FruitDistribution.FruitDistribution_API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Boolean checkForUser(String email) {
        List<User> all = repository.findAll();
        for(User user : all) {
            if(user.getEmail() != null && user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User findUserById(String id) {
        List<User> all = repository.findAll();
        for(User u : all) {
            if(Objects.equals(u.getId(), id)) {
                return u;
            }
        }

        return null;
    }

    public User findUserByEmail(String email) {
        List<User> all = repository.findAll();
        for(User u : all) {
            if(Objects.equals(u.getEmail(), email)) {
                return u;
            }
        }

        return null;
    }

    public User addNewUser(User u) {
        return repository.save(u);
    }

    public void deleteUser(User U) {
        repository.delete(U);
    }

    public void deleteAllUsers() {
        repository.deleteAll();
    }
}
