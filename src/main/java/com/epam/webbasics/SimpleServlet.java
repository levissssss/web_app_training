package com.epam.webbasics;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SimpleServlet extends HttpServlet {


    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html> \n"
                + "<html>\n"
                + "   <head>\n"
                + "\t\t<style>\n"
                + "\t\t\t#test{\n"
                + "\t\t\t   color: blue;\n"
                + "                font-size: xx-large;\n"
                + "\t\t\t}\n"
                + "\t\t</style>\n"
                + "      <meta charset=\"UTF-8\">\n"
                + "      <title>Title of the document</title>\n"
                + "   </head>\n"
                + "   <body> \n"
                + "\t\t<div id=\"test\">\n"
                + "\t\t\tLogged in as " + request.getSession().getAttribute("username") + "!\n"
                + "\t\t</div>\n"
                + "   </body>\n"
                + "</html>");
    }
}
