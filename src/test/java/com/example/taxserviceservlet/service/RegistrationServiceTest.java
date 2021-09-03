package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.exception.UserAlreadyExistsException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {

    RegistrationService registrationService = new RegistrationService();

    UserDTO userDTO = UserDTO.builder()
            .firstName("Name1")
            .lastName("Surname1")
            .email("testMyEmail@test.com")
            .password("password")
            .age("20")
            .ipn("123142124124")
            .personality("NATURAL_PERSON")
            .address("user_address")
            .userRole("USER")
            .build();

    @Test
    void registerUser() throws SQLException {
        assertEquals(userDTO, PojoConverter.convertUserEntityToDto(registrationService.registerUser(userDTO)));
    }

    @Test
    void register_user_expect_exception() {
        Exception exception = assertThrows(UserAlreadyExistsException.class, () -> {
            userDTO.setEmail("shtepa.jr@gmail.com");
            registrationService.registerUser(userDTO);
        });

        String expectedMessage = "User with this email exists";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}