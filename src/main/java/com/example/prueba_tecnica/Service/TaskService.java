package com.example.prueba_tecnica.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.prueba_tecnica.Models.Task;
import com.example.prueba_tecnica.Models.User;

public interface TaskService {
	
	/*
	 * Método para guardar una tarea
	 * */
	Task saveTask(Task task);
	
	/*
	 * Método para listar todas las tareas
	 * */
	List<Task> getTask();
	
	/*
	 * Método para obtener los datos de una tarea en especifico
	 * */
	Optional<Task> getTaskById(Long id);

	/*
	 * Método para actualizar una tarea
	 * */
	Task updateTask(Long id, Task task);
	
	/*
	 * Método para eliminar una tarea
	 * */
	void deleteTask(Long id);

	List<Task> filter(Optional<User> user, LocalDate parse, LocalDate parse2);

}
