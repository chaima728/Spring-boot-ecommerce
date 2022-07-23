package com.example.springbootecommerce;


import com.example.springbootecommerce.Models.User;
import com.example.springbootecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(path = { "/{id}" })
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

}
