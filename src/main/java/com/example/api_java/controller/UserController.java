package com.example.api_java.controller;

import com.example.api_java.exception.UserNotFoundException;
import com.example.api_java.model.User;
import com.example.api_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:2001")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/add")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/user/get-all")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/get/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/user/edit/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/user/delete/{id}")
    String deleteUser(@PathVariable Long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "Xóa id " + id + " thành công";
    }
}
