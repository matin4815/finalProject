package com.clarity.finalproject.service;


import com.clarity.finalproject.dto.UserDTO;
import com.clarity.finalproject.entity.User;
import com.clarity.finalproject.exceptions.InvalidUsername;
import com.clarity.finalproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userRepository.save(user);
    }

    @Transactional
    public User loginUser(UserDTO userInfo){
        User user = modelMapper.map(userInfo, User.class);
        User existingUser = findUser(user.getUserName());
        if(existingUser != null){
            if(existingUser.getPassword().equals(user.getPassword())){
                user.setIsLoggedIn(true);
                userRepository.save(user);
            }
        }
        return user;

    }
}
