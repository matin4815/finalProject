package com.clarity.finalproject.repository;

import com.clarity.finalproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users as u where u.user_name = :userName", nativeQuery = true)
    User findUser(String userName);
}
