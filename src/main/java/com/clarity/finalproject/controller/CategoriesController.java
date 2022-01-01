package com.clarity.finalproject.controller;

import com.clarity.finalproject.dto.CategoryDTO;
import com.clarity.finalproject.dto.TagsDTO;
import com.clarity.finalproject.service.CategoryService;
import com.clarity.finalproject.service.TagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping(value = {"/save"})
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO){
        return modelMapper.map(categoryService.saveCategoryByDTO(categoryDTO), CategoryDTO.class);
    }

    @GetMapping(value = "/get/names")
    public List<String> getAllCategoryNames(){
        return this.categoryService.findAllCategoryNames();
    }

    @GetMapping(value = "/get/{categoryName}")
    public String getCategoryName(@PathVariable(value = "categoryName") String categoryName){
        return categoryService.findCategory(categoryName);
    }


}
