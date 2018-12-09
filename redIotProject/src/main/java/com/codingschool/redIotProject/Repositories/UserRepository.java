package com.codingschool.redIotProject.Repositories;

import com.codingschool.redIotProject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
    List<User> findAll();
    List<User> findByNameContaining(String searchterm);
    User findById(long id);
    void deleteById(long id);


}
