package com.project.demo.repositories;

import com.project.demo.models.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  @Query("SELECT COUNT(u.name) FROM UserEntity u Where u.name= ?1")
  Long findByName(String name);

  @Query("SELECT COUNT(u.email) FROM UserEntity u Where u.email= ?1")
  Long findByEmail(String email);

}
