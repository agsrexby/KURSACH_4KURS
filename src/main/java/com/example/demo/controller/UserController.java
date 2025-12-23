package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    // GET all users
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // GET user by id
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    // POST create user
    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    // PUT update user
    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User updatedUser) {

        User user = userRepository.findById(id).orElseThrow();

        user.setName(updatedUser.getName());
        user.setPhone(updatedUser.getPhone());

        return userRepository.save(user);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
