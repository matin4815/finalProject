package com.clarity.finalproject.controller;

import com.clarity.finalproject.dto.UserDTO;
import com.clarity.finalproject.entity.User;
import com.clarity.finalproject.exceptions.InvalidUsername;
import com.clarity.finalproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/signup")
    public UserDTO signUpUser(@RequestBody UserDTO userDTO){
        return modelMapper.map(userService.signUpUser(userDTO), UserDTO.class);
    }

    // i have a working log in but i dont no how to map to a query exactly
    @PutMapping(value = "/login")
    public void loginUser(@RequestBody UserDTO userDTO){
        boolean didLogIn = this.userService.loginUser(userDTO);
        if(didLogIn){
            System.out.println("user is logged in");
        }else{
            System.out.println("didnt log in");
        }
    }

}
