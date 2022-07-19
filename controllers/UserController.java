package br.com.aulaapi.controllers;

import br.com.aulaapi.entities.User;
import br.com.aulaapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    public List<User> searchUser(){
        return userService.searchUser();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User searchUser(@PathVariable Long id){
        return userService.searchUser(id);
    }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User user){
        User existingUser = userService.searchUser(user.getId());
        if (existingUser != null) {
            return existingUser;
        }
        return userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}

