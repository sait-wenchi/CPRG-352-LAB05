/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author wenchi
 */
public class LoginServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the session
        HttpSession session = request.getSession();
        String operation = request.getParameter("logout");
        // check to see if the user wants to reset
        if( operation != null && operation.equals("logout")){
            // if the user has clcik the reset button, invalidate the session
            session.invalidate();
            // we still need a session for the rest of code, so get new session
            session = request.getSession();
            request.setAttribute("message", "user has successfully logged out");
        } 
        User user = (User)session.getAttribute("user");
        if (user == null)
        {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("username", user.getUsername());
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        AccountService account = new AccountService();
        User user = account.login(username, password);
        if( user != null)
        {
            session.setAttribute("user",user);
            session.setAttribute("login", "login");
            request.setAttribute("username",user.getUsername());
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
        request.setAttribute("message", "Invalid username/password");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
