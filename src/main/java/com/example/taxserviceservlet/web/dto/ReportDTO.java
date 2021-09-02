package com.example.taxserviceservlet.web.dto;

import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.entity.User;

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
        public ReportDTO build() {
            return this.report;
        }

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
                '}';
    }
}
