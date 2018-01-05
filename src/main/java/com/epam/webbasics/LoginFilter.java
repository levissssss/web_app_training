package com.epam.webbasics;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest)servletRequest);
        if (httpRequest.getSession().getAttribute("username") == null){
            String requestedPage = httpRequest.getRequestURI();
            ((HttpServletResponse)servletResponse).sendRedirect("/login?req=" + requestedPage);

        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
