<%-- 
    Document   : shoppingList
    Created on : Oct 23, 2020, 7:36:25 PM
    Author     : 829942
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
       
    </head>
    <body>
        <h1>Shopping List</h1>
        
        
        <div>
            Hello, ${username} <a href="./ShoppingList?action=logout">Logout</a>
     
        </div>
        <h2>List </h2>
        
        <form method="get" action="./ShoppingList">
        <div>
            Add item: <input type="text" name="addItem"   />
            <button type="submit" name="action" value="add">Add</button>
            
        </div>
            
            
            <c:if test="${!empty items}">
                <c:forEach items="${items}" var="list">
                    <div>
                        <input type="radio" name="radioButton" value="${list}"/>${list}
                    </div>
                </c:forEach>

                <button type="submit" name="action" value="delete">Delete</button>
            </c:if>
            

        
        </form>
    </body>
</html>
