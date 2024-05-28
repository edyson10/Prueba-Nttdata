package com.example.prueba_tecnica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.prueba_tecnica.Models.User;
import com.example.prueba_tecnica.Repository.UserRepository;
import com.example.prueba_tecnica.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
class PruebaTecnicaApplicationTests {

	@InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    /*
    @Test
    public void testFindAll() {
        List<User> users = Arrays.asList(new User(2L, "edyson", "edysonleal3@gmail.com", "3508927334"));
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getUsers();
        assertEquals(3, result.size());
    }
    */
    
    @Test
    void save() throws ParseException, JsonProcessingException {
        Mockito.doReturn(new User()).when(userService)
                .saveUser(null);

        var result = userRepository.save(Mockito.any());
        Assertions.assertNotNull(result);
    }

}
