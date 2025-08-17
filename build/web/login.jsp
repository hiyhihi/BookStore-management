<%-- 
    Document   : login
    Created on : Aug 15, 2025, 9:50:41 PM
    Author     : huyph
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookstore</title>
</head>
<body>
    <h2>Login</h2>

    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>

    <c:if test="${not empty successMessage}">
        <p style="color:green;">${successMessage}</p>
    </c:if>
    
    <form action="LoginServlet" method="post">
        <label>Username: </label>
        <input type="text" name="username" required><br><br>

        <label>Password: </label>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <p>Create new account? <a href="<%=request.getContextPath()%>/View/register.jsp">Register now</a></p>
</body>
</html>
