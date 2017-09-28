<%-- 
    Document   : login
    Created on : 20-Sep-2017, 2:05:46 PM
    Author     : 709317
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/HTML/header.html" />

        <h1>Login</h1>
        <div>
            <form action="Login" method="POST">
                Username: <input type="text" name="uname" value="${user.userName}"><br>
                Password: <input type="password" name="password" value="${user.password}"><br>
                
                <input type="submit" value="Login">
            </form>     
        </div>
      
        ${message}
        
<c:import url="/HTML/footer.html" />