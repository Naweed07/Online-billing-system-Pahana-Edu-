<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>


<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Pahana Edu</title>
</head>
<body>
   <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
<ul>
    <li><a href="register.jsp">Add Customer</a></li>
    <li><a href="inventory.jsp">View Inventory</a></li>
    <li><a href="billing.jsp">Create Bill</a></li>
    <li><a href="logout.jsp">Logout</a></li>
</ul>
</body>
</html>
