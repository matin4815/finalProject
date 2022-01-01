package com.clarity.finalproject.controller;

import com.clarity.finalproject.dto.TagsDTO;
import com.clarity.finalproject.service.TagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagsController {

    private TagsService tagsService;
    private ModelMapper modelMapper;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping(value = {"/save"})
    public TagsDTO saveTag(@RequestBody TagsDTO tagsDTO){
        return modelMapper.map(tagsService.saveTagByDTO(tagsDTO), TagsDTO.class);
    }
}
