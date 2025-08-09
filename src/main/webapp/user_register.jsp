<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register new user</title>
</head>
<body>
<form action="UserRegisterServlet" method="post">
    <h2>Staff Registration</h2>
    <input type="text" name="username" placeholder="Username" required /><br>
    <input type="password" name="password" placeholder="Password" required /><br>
    <button type="submit">Register</button><br>
    <c:if test="${param.error != null}">
        <p style="color:red;">Registration failed. Try a different username.</p>
    </c:if>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</form>


</body>
</html>