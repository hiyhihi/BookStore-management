<%-- 
    Document   : book_form
    Created on : Aug 17, 2025, 6:44:43 PM
    Author     : huyph
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Books" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
    <h2>
        <%= request.getAttribute("book") == null ? "Add new Book" : "Edit Book" %>
    </h2>

    <%
        Books book = (Books) request.getAttribute("book");
    %>

    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="<%= book == null ? "insert" : "update" %>">
        <% if (book != null) { %>
            <input type="hidden" name="id" value="<%= book.getId() %>">
        <% } %>

        <p>Title: <input type="text" name="title" value="<%= book != null ? book.getTitle() : "" %>"></p>
        <p>Author: <input type="text" name="author" value="<%= book != null ? book.getAuthor() : "" %>"></p>
        <p>Publisher: <input type="text" name="publisher" value="<%= book != null ? book.getPublisher() : "" %>"></p>
        <p>Price: <input type="number" step="0.01" name="price" value="<%= book != null ? book.getPrice() : "" %>"></p>
        <p>Stock Quantity: <input type="number" name="stockQuantity" value="<%= book != null ? book.getStockQuantity() : "" %>"></p>

        <p>
            <input type="submit" value="Submit">
            <a href="BookServlet?action=list">Back</a>
        </p>
    </form>
</body>
</html>

