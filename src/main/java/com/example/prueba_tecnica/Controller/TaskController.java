package com.example.prueba_tecnica.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba_tecnica.Exceptions.Mensaje;
import com.example.prueba_tecnica.Models.Task;
import com.example.prueba_tecnica.Models.User;
import com.example.prueba_tecnica.Service.TaskService;
import com.example.prueba_tecnica.Service.UserService;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
    private UserService userService;

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Task save(@RequestBody Task task) {
		Task saveTask = taskService.saveTask(task);
		return saveTask;
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<List<Task>> getUsers() {
		List<Task> task = taskService.getTask();
		return new ResponseEntity<List<Task>>(task, HttpStatus.OK);
	}

	@GetMapping(path = "/listar/{id}")
	public ResponseEntity<Task> findById(@PathVariable("id") Long id) {

		Optional<Task> task = taskService.getTaskById(id);

		return new ResponseEntity<Task>(task.get(), HttpStatus.OK);

	}

	@PutMapping(path = "/actualizar/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Task task) {
		Task tasks = taskService.updateTask(id, task);
		return new ResponseEntity(new Mensaje("Se actualizo la tarea correctamente."), HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
		try {
			taskService.deleteTask(id);
			return new ResponseEntity(new Mensaje("Se ha eliminado la tarea correctamente."), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/filter")
    public List<Task> filterTasks(@RequestParam Long userId, @RequestParam String startDate, @RequestParam String endDate) {
        Optional<User> user = userService.getUserById(userId);
        return taskService.filter(user, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
