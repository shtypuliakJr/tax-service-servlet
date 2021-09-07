package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.dao.impl.ReportDaoImpl;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;

public class DaoFactory {

    private static ReportDao reportDao;
    private static UserDao userDao;

    public static ReportDao getReportDaoInstance() {
        if (reportDao == null)
            reportDao = new ReportDaoImpl();

        return reportDao;
    }

    public static UserDao getUserDaoInstance() {
        if (userDao == null)
            userDao = new UserDaoImpl();

        return userDao;
    }
}
