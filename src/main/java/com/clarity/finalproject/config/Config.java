package com.clarity.finalproject.config;

import com.clarity.finalproject.dto.CategoryDTO;
import com.clarity.finalproject.dto.TagsDTO;
import com.clarity.finalproject.entity.Category;
import com.clarity.finalproject.entity.Tag;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public ModelMapper myModelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<Tag, TagsDTO> tagPropertyMapper = modelMapper.createTypeMap(Tag.class, TagsDTO.class);
        TypeMap<Category, CategoryDTO> categoryPropertyMapper = modelMapper.createTypeMap(Category.class, CategoryDTO.class);
        return modelMapper;
    }

    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
