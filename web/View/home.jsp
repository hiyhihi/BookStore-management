<%-- 
    Document   : home.jsp
    Created on : Aug 16, 2025, 5:35:36?PM
    Author     : huyph
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = (String) session.getAttribute("username");
    if (user == null) {
        response.sendRedirect("login.jsp"); // nếu chưa login thì về login
    }
%>
<html>
<head>
    <title>Bookstore - Home</title>
</head>
<body>
    <h1>Hello, <%= user %>!</h1>

    <ul>
        <li><a href="<%=request.getContextPath()%>/BookServlet?action=list">Manage Book Store</a></li>
        <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
    </ul>
</body>
</html>


