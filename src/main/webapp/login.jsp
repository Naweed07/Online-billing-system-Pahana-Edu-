<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login to Pahan Edu</title>
</head>
<body>
<form action="LoginServlet" method="post">
    <h2>Staff Login</h2>
    <input type="text" name="username" placeholder="Username" required /><br>
    <input type="password" name="password" placeholder="Password" required /><br>
    <button type="submit">Login</button><br>
    <c:if test="${param.error != null}">
        <p style="color:red;">Invalid username or password!</p>
    </c:if>
    <p>New user? <a href="user_register.jsp">Register here</a></p>
</form>



</body>
</html>