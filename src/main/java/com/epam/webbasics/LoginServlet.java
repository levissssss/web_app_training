package com.epam.webbasics;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("req", req.getParameter("req"));
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("uname");
        String password = req.getParameter("pw");
        Map<String, String> users;
        ServletContext context = req.getServletContext();

        synchronized (context){
            users = (Map<String, String>) context.getAttribute("users");
            if (null == users){
                users = Collections.emptyMap();
            }
        }

        if (users.containsKey(userName) && users.get(userName).equals(password)){
            req.getSession().setAttribute("invalid", "false");
            req.getSession().setAttribute("username", userName);
            if (req.getParameter("req").equals("/login")) {
                resp.sendRedirect("index.jsp");
            } else {
                resp.sendRedirect(req.getParameter("req"));
            }
        }else {
            req.getSession().setAttribute("invalid", "true");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
