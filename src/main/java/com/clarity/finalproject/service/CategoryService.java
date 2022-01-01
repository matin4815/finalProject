package com.clarity.finalproject.service;


import com.clarity.finalproject.dto.CategoryDTO;
import com.clarity.finalproject.entity.Category;
import com.clarity.finalproject.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public Category saveCategoryByDTO(CategoryDTO categoryDTO){
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }

    public List<String> findAllCategoryNames(){
        List<Category> categories = this.categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<String>();
        for(Category category: categories){
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }

    public String findCategory(String categoryName){
        Category category = this.categoryRepository.findCategory(categoryName);
        return category.getName();
    }
}
