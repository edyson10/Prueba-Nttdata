package com.example.prueba_tecnica.Service;

import java.util.List;
import java.util.Optional;

import com.example.prueba_tecnica.Models.User;

public interface UserService {

	/*
	 * Método para guardar usuario
	 * */
	User saveUser(User user);
	
	/*
	 * Método para listar todos los usuario
	 * */
	List<User> getUsers();
	
	/*
	 * Método para obtener los datos de un usuario en especifico
	 * */
	Optional<User> getUserById(Long id);
	
	/*
	 * Método para actualizar un usuario
	 * */
	User updateUser(Long id, User user);
	
	/*
	 * Método para eliminar un usuario
	 * */
	void deleteUser(Long id);
	
	
}
