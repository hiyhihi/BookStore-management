<%-- 
    Document   : book_view
    Created on : Aug 17, 2025, 6:44:58 PM
    Author     : huyph
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Books" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book's Detail</title>
</head>
<body>
    <h2>Book's Detail</h2>

    <%
        Books book = (Books) request.getAttribute("book");
        if (book != null) {
    %>
        <p><b>ID:</b> <%= book.getId() %></p>
        <p><b>Title:</b> <%= book.getTitle() %></p>
        <p><b>Author:</b> <%= book.getAuthor() %></p>
        <p><b>Publisher:</b> <%= book.getPublisher() %></p>
        <p><b>Price:</b> <%= book.getPrice() %></p>
        <p><b>Stock Quantity:</b> <%= book.getStockQuantity() %></p>
    <% } %>

    <p>
        <a href="BookServlet?action=edit&id=<%= book.getId() %>">Edit</a> |
        <a href="BookServlet?action=list">Back</a>
    </p>
</body>
</html>


