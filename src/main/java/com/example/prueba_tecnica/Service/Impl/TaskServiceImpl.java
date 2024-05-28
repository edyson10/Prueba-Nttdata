package com.example.prueba_tecnica.Service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.Exceptions.ResourceNotFoundException;
import com.example.prueba_tecnica.Models.Task;
import com.example.prueba_tecnica.Models.User;
import com.example.prueba_tecnica.Repository.TaskRepository;
import com.example.prueba_tecnica.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getTask() {
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> getTaskById(Long id) {
		Optional<Task> task = taskRepository.findById(id);

		if (task.isEmpty()) {
			throw new ResourceNotFoundException("No existe esa tarea con ese ID");
		}

		return taskRepository.findById(id);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		Optional<Task> tasks = taskRepository.findById(id);
		tasks.get().setTitulo(task.getTitulo());
		tasks.get().setDescripcion(task.getDescripcion());
		tasks.get().setEstado(task.getEstado());
		return taskRepository.save(tasks.get());
	}

	@Override
	public void deleteTask(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		if (task.isEmpty()) {
			throw new ResourceNotFoundException("No existe esa tarea con ese ID");
		}

		taskRepository.deleteById(id);
	}

	@Override
	public List<Task> filter(Optional<User> user, LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return taskRepository.findByUserAndDueDateBetween(user, startDate, endDate);
	}

}
