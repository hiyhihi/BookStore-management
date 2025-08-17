<%-- 
    Document   : book
    Created on : Aug 17, 2025, 6:35:23 PM
    Author     : huyph
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Books" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h2>Book List</h2>
    
    <p><a href="<%=request.getContextPath()%>/View/home.jsp">Home</a></p>
    <form action="BookServlet" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" placeholder="Book title...">
        <input type="submit" value="Search">
    </form>

    <p><a href="BookServlet?action=new">Add new Book</a></p>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>Publisher</th><th>Price</th><th>Stock Quantity</th><th>Actions</th>
        </tr>
        <%
            List<Books> list = (List<Books>) request.getAttribute("listBooks");
            if (list != null) {
                for (Books b : list) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getPublisher() %></td>
            <td><%= b.getPrice() %></td>
            <td><%= b.getStockQuantity() %></td>
            <td>
                <a href="BookServlet?action=view&id=<%= b.getId() %>">View</a> | 
                <a href="BookServlet?action=edit&id=<%= b.getId() %>">Edit</a> | 
                <a href="BookServlet?action=delete&id=<%= b.getId() %>" onclick="return confirm('Confirm delete this book?');">Delete</a>
            </td>
        </tr>
        <% }} %>
    </table>
</body>
</html>



