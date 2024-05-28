package com.example.prueba_tecnica.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.Exceptions.ResourceNotFoundException;
import com.example.prueba_tecnica.Models.User;
import com.example.prueba_tecnica.Repository.UserRepository;
import com.example.prueba_tecnica.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isEmpty()) {
			throw new ResourceNotFoundException("No existe esa usuario con ese ID");
		}

		return userRepository.findById(id);
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> usuario = userRepository.findById(id);
		usuario.get().setNombre(user.getNombre());
		usuario.get().setEmail(user.getEmail());
		usuario.get().setTelefono(user.getTelefono());
		return userRepository.save(usuario.get());
	}

	@Override
	public void deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new ResourceNotFoundException("No existe ese usuario con ese ID");
		}

		userRepository.deleteById(id);
	}

}
