package com.example.taxserviceservlet.util;

import com.example.taxserviceservlet.entity.*;
import com.example.taxserviceservlet.web.dto.ReportDTO;
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
        return UserDTO.Builder()
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

    public static ReportDTO convertReportEntityToDTO(Report report) {
        return new ReportDTO.Builder()
                .id(report.getId())
                .income(report.getIncome())
                .taxRate(report.getTaxRate())
                .taxPeriod(report.getTaxPeriod())
                .year(report.getYear())
                .status(report.getStatus())
                .reportDate(report.getReportDate())
                .comment(report.getComment())
                .userId(report.getUserId())
                .build();
    }
}
