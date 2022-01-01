package com.clarity.finalproject.controller;

import com.clarity.finalproject.dto.TagsDTO;
import com.clarity.finalproject.service.TagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/get/names")
    public List<String> getAllTagNames(){
        return this.tagsService.findAllTagNames();
    }

    @GetMapping(value = "/get/{tagName}")
    public String getTagName(@PathVariable(value = "tagName") String tagName){
        return tagsService.findTag(tagName);
    }



}
