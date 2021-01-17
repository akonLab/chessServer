package com.company.сontrollers;

import com.company.models.User;
import com.company.util.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogIn")
public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = request.getParameter("chess");

        String mess1;

        if(status.equals("white")){
            mess1 = "Server choose white, server plays with black";
        }
        else
            mess1 = "Server choose black, server plays with white";

        UserDB userDao = UserDB.getInstance();
        User user = userDao.getUserByEmail(email);
        if(user!=null){
            if(user.getPassword().equals(password)){
                request.setAttribute("mess1", mess1);
                request.getRequestDispatcher("jsp/chat.jsp").forward(request, response);
            }else{
                String mess = "Incorrect password, try again!!!";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("jsp/log.jsp").forward(request, response);
            }
        }else{
            String mess = "Incorrect username, try again!!!";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("jsp/log.jsp").forward(request, response);
        }
    }
}
