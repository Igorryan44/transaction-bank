package com.igor_dev.transaction_bank.controller;

import com.igor_dev.transaction_bank.model.User;
import com.igor_dev.transaction_bank.servcice.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatusCode.valueOf(406)).build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody /*<--- Não pode faltar pois lê o payload*/ User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(202)).build();
    }
}
