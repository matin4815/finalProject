package com.clarity.finalproject.config;

import com.clarity.finalproject.dto.TagsDTO;
import com.clarity.finalproject.entity.Tag;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper myModelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<Tag, TagsDTO> propertyMapper = modelMapper.createTypeMap(Tag.class, TagsDTO.class);
        return modelMapper;
    }
}
