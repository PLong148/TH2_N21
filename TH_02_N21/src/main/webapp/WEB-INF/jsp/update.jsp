<%-- 
    Document   : update
    Created on : Apr 9, 2022, 9:19:47 AM
    Author     : Hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${message}</h1>
        <form action="/update" method="post">
            <h1>Product</h1>
            <label>Product Code:</label>
            <input type="text" value="${code}" name="code"> <br><br>
            <label>Product Description:</label>
            <input type="text" value="${des}"  name="description"><br><br>
            <label>Product Price:</label>
            <input type="number" step="0.01" value="${price}" name="price" min="0"><br><br>
            <input type="submit" value ="Update Product" style="color: #000; border: solid 1px #000; text-decoration: none; padding: 4px; background-color: #fff">
            <a href="./products" style="color: #000; border: solid 1px #000; text-decoration: none; padding: 4px; margin-left: 4px">View Products</a>
        </form>

    </body>
</html>
