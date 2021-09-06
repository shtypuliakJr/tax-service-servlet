package com.example.taxserviceservlet.web.dto;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;

import java.sql.Date;

public class ReportDTO {

    Long id;

    private Integer income;

    private Integer taxRate;

    private String taxPeriod;

    private Integer year;

    private Date reportDate;

    private String status;

    private String comment;

    private Long userId;
    
    private UserDTO userDTO;

    public static Builder builder() {
        return new ReportDTO.Builder();
    }

    public static class Builder {

        ReportDTO report;

        public Builder() { report = new ReportDTO(); }

        public ReportDTO.Builder id(Long id) {
            this.report.id = id;
            return this;
        }

        public ReportDTO.Builder taxPeriod(TaxPeriod taxPeriod) {
            this.report.taxPeriod = String.valueOf(taxPeriod);
            return this;
        }

        public ReportDTO.Builder year(Integer year) {
            this.report.year = year;
            return this;
        }

        public ReportDTO.Builder income(Integer income) {
            this.report.income = income;
            return this;
        }

        public ReportDTO.Builder taxRate(Integer taxRate) {
            this.report.taxRate = taxRate;
            return this;
        }

        public ReportDTO.Builder reportDate(Date reportDate) {
            this.report.reportDate = reportDate;
            return this;
        }

        public ReportDTO.Builder status(Status status) {
            this.report.status = String.valueOf(status);
            return this;
        }

        public ReportDTO.Builder comment(String comment) {
            this.report.comment = comment;
            return this;
        }

        public ReportDTO.Builder userId(Long userId) {
            this.report.userId = userId;
            return this;
        }
        public ReportDTO.Builder user(UserDTO user) {
            this.report.userDTO = user;
            return this;
        }
        public ReportDTO build() {
            return this.report;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxPeriod() {
        return taxPeriod;
    }

    public void setTaxPeriod(String taxPeriod) {
        this.taxPeriod = taxPeriod;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "id=" + id +
                ", income=" + income +
                ", taxRate=" + taxRate +
                ", taxPeriod='" + taxPeriod + '\'' +
                ", year=" + year +
                ", reportDate=" + reportDate +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                ", userDTO=" + userDTO +
                '}';
    }
}
