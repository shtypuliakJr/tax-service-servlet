package com.example.taxserviceservlet.entity;

import java.sql.Date;

public class Report {

    private Long id;

    private TaxPeriod taxPeriod;

    private Integer year;

    private Integer income;

    private Integer taxRate;

    private Date reportDate;

    private Status status;

    private String comment;

    private Long userId;


    public static class Builder {

        Report report;

        public Builder() { report = new Report(); }

        public Builder id(Long id) {
            this.report.id = id;
            return this;
        }

        public Builder taxPeriod(TaxPeriod taxPeriod) {
            this.report.taxPeriod = taxPeriod;
            return this;
        }

        public Builder year(Integer year) {
            this.report.year = year;
            return this;
        }

        public Builder income(Integer income) {
            this.report.income = income;
            return this;
        }

        public Builder taxRate(Integer taxRate) {
            this.report.taxRate = taxRate;
            return this;
        }

        public Builder reportDate(Date reportDate) {
            this.report.reportDate = reportDate;
            return this;
        }

        public Builder status(Status status) {
            this.report.status = status;
            return this;
        }

        public Builder comment(String comment) {
            this.report.comment = comment;
            return this;
        }

        public Builder userId(Long userId) {
            this.report.userId = userId;
            return this;
        }
        public Report build() {
            return this.report;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaxPeriod getTaxPeriod() {
        return taxPeriod;
    }

    public void setTaxPeriod(TaxPeriod taxPeriod) {
        this.taxPeriod = taxPeriod;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taxPeriod=" + taxPeriod +
                ", year=" + year +
                ", income=" + income +
                ", taxRate=" + taxRate +
                ", reportDate=" + reportDate +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                '}';
    }
}
