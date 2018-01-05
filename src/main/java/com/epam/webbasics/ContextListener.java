package com.epam.webbasics;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ContextListener implements ServletContextListener {

    public static final String USERS_PROPERTIES = "users.properties";

    public void contextInitialized(ServletContextEvent sce) {
        Map<String, String> users = new HashMap<String, String>();;
        synchronized (sce.getServletContext()){
            sce.getServletContext().setAttribute("users", users);
        }
        Properties usersFile = loadUsersFile();
        for (String user : usersFile.stringPropertyNames()){
            users.put(user, usersFile.getProperty(user));
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        Map<String, String> users;
        ServletContext context = sce.getServletContext();
        synchronized (context){
            users = (Map<String, String>) context.getAttribute("users");
        }
        Properties usersFile = loadUsersFile();
        for (String user : users.keySet()){
            usersFile.setProperty(user, users.get(user));
        }

        try {
            File file = new File("C:\\Users\\Levente_Lakatos\\Documents\\Java Academy\\Web Basics\\sample_web_app\\src\\main\\resources\\users.properties");
            FileWriter writer = new FileWriter(file);
            usersFile.store(writer, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties loadUsersFile(){
        Properties properties = new Properties();
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(USERS_PROPERTIES);
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
