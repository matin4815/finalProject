//package com.clarity.finalproject.service;
//
//import com.clarity.finalproject.entity.CustomUserDetails;
//import com.clarity.finalproject.entity.User;
//import com.clarity.finalproject.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUser(username);
//        if(user == null){
//            throw new UsernameNotFoundException("user not found");
//        }
//        return new CustomUserDetails(user);
//    }
//}
