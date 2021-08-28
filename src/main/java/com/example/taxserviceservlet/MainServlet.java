package com.example.taxserviceservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "main", value = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("main");
        System.out.println("redirect");
        System.out.println("redirect param" + req.getParameter("value"));
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("key", req.getParameter("value"));
        resp.addCookie(cookie);
        session.setAttribute("value", req.getParameter("value"));

//        req.setAttribute("value", req.getParameter("value"));
//        resp.sendRedirect("user/reports?value=" + req.getParameter("value"));
        resp.sendRedirect("user/reports");
//        req.getRequestDispatcher("main.jsp").forward(req, resp);

    }
}
