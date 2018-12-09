package com.codingschool.redIotProject.Controllers;


import com.codingschool.redIotProject.Entities.User;
import com.codingschool.redIotProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    // returns all users
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }


    // Returns user by id
    @GetMapping("/{id}")
    public User findOne(@PathVariable long id) {
        return userService.findById(id);
    }


    // Creates new User
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    // updates username found by id
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUsername(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUsername(user, id);
    }

    // deletes user by id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteById(id);
    }


    @RequestMapping("/login")
    public Map<String,String> login(@RequestBody User user) {
        Map<String,String> tmp= new HashMap<>();
        tmp.put("auth",(user.getMail().equals("email") && user.getPassword().equals("password"))+"");
        tmp.put("role", user.getRole().toString());
        return tmp;

    }



}