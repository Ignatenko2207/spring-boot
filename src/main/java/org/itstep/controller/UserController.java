package org.itstep.controller;

import org.itstep.entity.User;
import org.itstep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        if (savedUser != null) {
            return new ResponseEntity<User>(savedUser, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User savedUser = userService.update(user);
        if (savedUser != null) {
            return new ResponseEntity(savedUser, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/get-one")
    public ResponseEntity<User> getOne() {
        return null;
    }

    @GetMapping("/get-text")
    public ResponseEntity<String> getText() {
        return new ResponseEntity("Hello!", HttpStatus.OK);
    }
}
