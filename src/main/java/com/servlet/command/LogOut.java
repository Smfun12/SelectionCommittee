package com.servlet.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("login");
        request.getSession().setAttribute("login","none");
        HashSet<String> loggedUsers =
                (HashSet<String>) request.getSession().getServletContext().getAttribute("loggedUsers");

        loggedUsers.remove(user);
        request.getSession().getServletContext().setAttribute("loggedUsers",loggedUsers);
        return "/index.jsp";
    }
}
