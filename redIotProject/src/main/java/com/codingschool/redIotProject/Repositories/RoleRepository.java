package com.codingschool.redIotProject.Repositories;

import com.codingschool.redIotProject.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findAll();
    Role findByRole(String role);
    
}
