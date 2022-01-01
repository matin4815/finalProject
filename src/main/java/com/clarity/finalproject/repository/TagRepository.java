package com.clarity.finalproject.repository;

import com.clarity.finalproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "select * from tags as t where t.name = :tagName", nativeQuery = true)
    Tag findTag(String tagName);
}
