package com.example.taxserviceservlet.web.dto;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.User;

import java.sql.Date;

public class ReportDTO {

    Long id;

    private String income;

    private String taxRate;

    private String taxPeriod;

    private Integer year;

    private Date reportDate;

    private Status status;

    private String comment;

    private User user;

    private Long userId;

}
