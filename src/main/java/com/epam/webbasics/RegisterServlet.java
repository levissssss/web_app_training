package com.epam.webbasics;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        String userName = req.getParameter("uname");
        String password = req.getParameter("pw");
        synchronized (context){
            Map<String, String> users = (Map<String, String>) context.getAttribute("users");
            if (null == users){
                users = new HashMap<String, String>();
                context.setAttribute("users", users);
            }
            users.put(userName, password);
        }
        req.getRequestDispatcher("/login").forward(req, resp);
    }
}
