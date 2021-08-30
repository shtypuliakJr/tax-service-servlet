package com.example.taxserviceservlet.util;

import com.example.taxserviceservlet.entity.Personality;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.web.dto.UserDTO;

import java.sql.Date;
import java.time.LocalDateTime;

public class PojoConverter {

    public static User convertUserDtoToEntity(UserDTO userDTO) {

            return new User.Builder()
                    .firstName(userDTO.getFirstName())
                    .lastName(userDTO.getLastName())
                    .email(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .age(Integer.parseInt(userDTO.getAge()))
                    .address(userDTO.getAddress())
                    .ipn(userDTO.getIpn())
                    .dateOfRegistration(userDTO.getDateOfRegistration())
                    .personality(Personality.valueOf(userDTO.getPersonality()))
                    .build();
    }

    public static UserDTO convertUserEntityToDto(User user) {
        return new UserDTO.Builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(String.valueOf(user.getAge()))
                .ipn(user.getIpn())
                .dateOfRegistration(user.getDateOfRegistration())
                .address(user.getAddress())
                .personality(user.getPersonality().toString())
                .userId(user.getUserId())
                .build();
    }
}
