package com.example.taxserviceservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FilterTest", value = "/filter-test")
public class FilterTest extends HttpServlet {
    List<User> userList;

    @Override
    public void init() throws ServletException {
        userList = new ArrayList<>();
        userList.add(new User(1, "Name1"));
        userList.add(new User(2, "Name2"));
        userList.add(new User(3, "Name3"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        if (id != null && name != null)
            userList.add(new User(Integer.parseInt(id), name));
        req.setAttribute("users", userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/filter-test.jsp");
        requestDispatcher.forward(req, resp);
    }
}
