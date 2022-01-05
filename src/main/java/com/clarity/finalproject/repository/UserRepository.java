package com.clarity.finalproject.repository;

import com.clarity.finalproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users as u where u.user_name = :userName", nativeQuery = true)
    User findUser(String userName);

    @Transactional
    @Modifying
    @Query(value = "update users set is_logged_in = ?1 where user_name = ?2", nativeQuery = true)
    boolean loginUser(boolean LogIn, String userName);
}
