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
        <form action="/edit" method="post">
            <h1>Product</h1>
            <label>Product Code: </label> 
            <input type="text" value="${product.code}" name="code" disabled><br><br>
            <input type="hidden" value="${product.code}" name="code">
            <label>Product Description:</label>
            <input type="text" value="${product.description}" name="description"><br><br>
            <label>Product Price:</label>
            <input type="text" value="${product.price}" name="price" > <br><br>
            <input type="submit" value ="Update Product" style="color: #000; border: solid 1px #000; text-decoration: none; padding: 4px; background-color: #fff">
            <a href="./product" style="color: #000; border: solid 1px #000; text-decoration: none; padding: 4px; margin-left: 4px">View Products</a>
        </form>

    </body>
</html>
