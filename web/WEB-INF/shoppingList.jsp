<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <title>Shopping List Page</title>       
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>
        <h2>List</h2>
        
        <form action="ShoppingList?action=add" method="post">
            <label for="addItem">Add Item:</label> 
            <input type="text" name="addItem">            
            <input type="submit" name="submit" value="Add">
        </form>
        
        <form action="ShoppingList?action=delete" method="post">
            <c:forEach var="item" items="${arrItems}">
                <br>
                <label for="deleteItem"></label>
                <input type="radio" name="deleteItem" value="${item}">
                <c:out value="${item}"/>             
            </c:forEach>
                <br>
                <input type="submit" name="delete"  value="Delete">
        </form>
        <div>${message}</div>
    </body>
</html>
