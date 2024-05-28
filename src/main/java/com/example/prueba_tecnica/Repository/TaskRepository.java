package com.example.prueba_tecnica.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba_tecnica.Models.Task;
import com.example.prueba_tecnica.Models.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUserAndDueDateBetween(Optional<User> user, LocalDate startDate, LocalDate endDate);

}
