package com.clarity.finalproject.service;


import com.clarity.finalproject.dto.TagsDTO;
import com.clarity.finalproject.entity.Tag;
import com.clarity.finalproject.repository.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TagsService {

    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    public TagsService(TagRepository tagRepository, ModelMapper modelMapper) {
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    public Tag saveTagByDTO(TagsDTO tagsDTO){
        Tag tag = modelMapper.map(tagsDTO, Tag.class);
        return tagRepository.save(tag);
    }
}
