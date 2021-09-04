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
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(String.valueOf(user.getAge()))
                .ipn(user.getIpn())
                .dateOfRegistration(user.getDateOfRegistration())
                .address(user.getAddress())
                .personality(String.valueOf(user.getPersonality()))
                .userRole(String.valueOf(user.getUserRole()))
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
                .user(PojoConverter.convertUserEntityToDto(report.getUser()))
                .build();
    }

    public static Report convertReportDTOToEntity(ReportDTO reportDTO) {
        return new Report.Builder()
                .id(reportDTO.getId())
                .income(reportDTO.getIncome())
                .taxRate(reportDTO.getTaxRate())
                .taxPeriod(TaxPeriod.valueOf(reportDTO.getTaxPeriod()))
                .year(reportDTO.getYear())
                .status(Status.valueOf(reportDTO.getStatus()))
                .reportDate(reportDTO.getReportDate())
                .comment(reportDTO.getComment())
                .userId(reportDTO.getUserId())
                .build();
    }
}
