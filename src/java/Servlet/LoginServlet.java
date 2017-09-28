/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Class.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 709317
 */
public class LoginServlet extends HttpServlet {

    protected void UserService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
                
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        
    //    User user = new User(userName,password);
    //    request.setAttribute("user",user);
        
    //    request.setAttribute("username", userName);
    //    request.setAttribute("password", password);
        
        if(userName.equalsIgnoreCase("adam")&&password.equalsIgnoreCase("password")||
              userName.equalsIgnoreCase("betty")&&password.equalsIgnoreCase("password")  )
        {
            request.setAttribute("uname", userName);
            getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request,response);
            
         
        }
        
        else
        {
            
            request.setAttribute("message", "Invalid username or password!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            
           
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String logoutMessage = request.getParameter("message");
        request.setAttribute("message", logoutMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
       

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        
        User user = new User(userName,password);
        request.setAttribute("user",user);
        
        if(userName == null || userName.isEmpty() || 
                password == null || password.isEmpty())
        {
            
            request.setAttribute("message", "Both values are required! ");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            
            
        }
        
        else
        {
             
            UserService(request,response);
        }
    
    }


}