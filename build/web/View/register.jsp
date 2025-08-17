<%-- 
    Document   : register
    Created on : Aug 17, 2025, 5:23:03 PM
    Author     : huyph
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register Form</h2>
    <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <label>Name:</label>
        <input type="text" name="fullname" required><br>

        <label>Phone:</label>
        <input type="text" name="phone"><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <input type="submit" value="Signup">
    </form>

    <p style="color:green;">
        ${message}
    </p>
    <p style="color:red;">
        ${errorMessage}
    </p>
</body>
</html>

