<%-- 
    Document   : product
    Created on : Apr 9, 2022, 8:40:29 AM
    Author     : Hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>Products</h1>
        <table cellpadding="5" border=1>
            <tr valign="bottom">
                <th align="left">Code</th>
                <th align="left">Description</th>
                <th align="left">Price</th>
                <th align="left"></th>
                <th align="left"></th>
            </tr>
            <c:forEach items="${products}" var="item">
                <tr>
                    <td>${item.code}</td>
                    <td>${item.description}</td>
                    <td>$ ${item.price}</td>                                       
                    <td><a href="edit?code=${item.code}">Edit</a></td>
                    <td><a href="confirmdelete?code=${item.code}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="/update" style="color: #000; border: solid 1px #000; text-decoration: none; padding: 4px">Add Product</a>
    </body>
</html>
