package com.stackroute.neo4J.controller;

import com.stackroute.neo4J.domain.User;
import com.stackroute.neo4J.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/v1/")
public class UserController {

    private UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        System.out.println(user);
        User savedUser=userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int uId)
    {
        User foundUserById = userService.getUserById(uId);
        return new ResponseEntity<>(foundUserById, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "user")
    public ResponseEntity<?> deleteUserById(@RequestParam int uId) {

        User deletedUser=userService.deleteUserById(uId);
        return new ResponseEntity<>(deletedUser,HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping(value = "allusers")
    public ResponseEntity<?> getAllUsers() {

        Collection<User> collectionOfUsers=userService.getAllUsers();
        return new ResponseEntity<>(collectionOfUsers,HttpStatus.OK);
    }

    @PutMapping(value = "user")
    public ResponseEntity<?> updateUser( @RequestBody User userToUpdate) {

        User updatedUser=userService.updateUser(userToUpdate);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

}