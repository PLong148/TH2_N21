<%-- 
    Document   : delete
    Created on : Apr 9, 2022, 10:33:05 AM
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
        <h1>Are your sure delete this product?</h1>
        <p>product code: ${product.code}</p>
        <p>product description: ${product.description}</p>
        <p>product price: ${product.price}</p>
        <a href="/delete?code=${product.code}">YES</a>
        <a href="/products">NO</a>
    </body>
</html>
