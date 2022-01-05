package com.clarity.finalproject.service;


import com.clarity.finalproject.dto.UserDTO;
import com.clarity.finalproject.entity.User;
import com.clarity.finalproject.exceptions.InvalidUsername;
import com.clarity.finalproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public User findUser(String userName){
        return userRepository.findUser(userName);
    }

    public User signUpUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public boolean loginUser(UserDTO userDTO){
        boolean didLogIn = false;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        User existingUser = findUser(userDTO.getUserName());
        if(existingUser != null){
            if(existingUser.getPassword().equals(userDTO.getPassword())){
                this.userRepository.loginUser(true, userDTO.getUserName());
                didLogIn = true;
            }
        }else{
            System.out.println("this user name does not exist");
        }
        return didLogIn;
    }

}
