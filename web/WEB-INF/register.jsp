<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <title>Register Page</title>       
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post">
            <input type="hidden" name="action" value="register">
            <label for="username">Username:</label> 
            <input type="text" name="username">
            <input type="submit" name="register" value="Register name" >
        </form>
        <div>${message}</div>
    </body>
</html>
