package com.example.prueba_tecnica.Controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba_tecnica.Exceptions.Mensaje;
import com.example.prueba_tecnica.Models.User;
import com.example.prueba_tecnica.Service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user) {		
		User saveUser = userService.saveUser(user);
		return saveUser;
	}
	
	@GetMapping(path = "/listar")
    public ResponseEntity<List<User>> getUsers(){
        List<User> user = userService.getUsers();
        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
    }
	
	@GetMapping(path = "/listar/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		
		Optional<User> user = userService.getUserById(id);
		
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/actualizar/{id}")
	 public ResponseEntity update(@PathVariable("id") Long id, @RequestBody User user) {				 	
		 User users = userService.updateUser(id, user);
		 return new ResponseEntity(new Mensaje("Se actualizo el usuario correctamente."), HttpStatus.OK);
	}
	
	 @DeleteMapping("/eliminar/{id}")
	 public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
		 try {
			 userService.deleteUser(id);
			 return new ResponseEntity(new Mensaje("Se ha eliminado el usuario correctamente."), HttpStatus.NO_CONTENT);
		 } catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
}
