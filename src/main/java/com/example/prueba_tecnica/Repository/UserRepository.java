package com.example.prueba_tecnica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba_tecnica.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
