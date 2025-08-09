<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Registration Success</title></head>
<body>
  <h2>Customer Registered</h2>
  <p>Account number: ${accountNumber}</p>
  <p>Name: ${customer.name}</p>
  <a href="${pageContext.request.contextPath}/register">Register another</a>
</body>
</html>