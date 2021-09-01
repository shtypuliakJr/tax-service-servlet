package com.example.taxserviceservlet.web.dto;

import java.util.Map;

public class StatisticDTO {

    private Long countOfUsers;
    private Long countOfReports;
    private Long countOfInspectors;

    private Integer processingReports;
    private Integer approvedReports;
    private Integer disapprovedReports;

    Map<Integer, Long> countReportsPerYear;


    public Long getCountOfUsers() {
        return countOfUsers;
    }

    public void setCountOfUsers(Long countOfUsers) {
        this.countOfUsers = countOfUsers;
    }

    public Long getCountOfReports() {
        return countOfReports;
    }

    public void setCountOfReports(Long countOfReports) {
        this.countOfReports = countOfReports;
    }

    public Long getCountOfInspectors() {
        return countOfInspectors;
    }

    public void setCountOfInspectors(Long countOfInspectors) {
        this.countOfInspectors = countOfInspectors;
    }

    public Integer getProcessingReports() {
        return processingReports;
    }

    public void setProcessingReports(Integer processingReports) {
        this.processingReports = processingReports;
    }

    public Integer getApprovedReports() {
        return approvedReports;
    }

    public void setApprovedReports(Integer approvedReports) {
        this.approvedReports = approvedReports;
    }

    public Integer getDisapprovedReports() {
        return disapprovedReports;
    }

    public void setDisapprovedReports(Integer disapprovedReports) {
        this.disapprovedReports = disapprovedReports;
    }

    public Map<Integer, Long> getCountReportsPerYear() {
        return countReportsPerYear;
    }

    public void setCountReportsPerYear(Map<Integer, Long> countReportsPerYear) {
        this.countReportsPerYear = countReportsPerYear;
    }

    public static class Builder extends StatisticDTO {

    }
}
