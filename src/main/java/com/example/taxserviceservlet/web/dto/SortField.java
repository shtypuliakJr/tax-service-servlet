package com.example.taxserviceservlet.web.dto;

public enum SortField {
    YEAR_OLD("Year old", "year", "asc"),
    YEAR_NEW("Year new", "year", "desc"),

    DATE_OLD("Date old", "reportDate", "asc"),
    DATE_NEW("Date new", "reportDate", "desc");

    public String sortName;
    public String fieldInTable;
    public String direction;

    SortField(String sortName, String fieldInTable, String direction) {
        this.sortName = sortName;
        this.fieldInTable = fieldInTable;
        this.direction = direction;
    }

    public String getSortName() {
        return sortName;
    }

    public String getDirection() {
        return direction;
    }

    public String getFieldInTable() {
        return fieldInTable;
    }
}
