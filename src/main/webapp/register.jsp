<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Customer</title>
</head>
<body>
  <h2>Register New Customer</h2>
<form method="post" action="register">
    <label>Name: <input type="text" name="name" required></label><br>
    <label>Address: <input type="text" name="address"></label><br>
    <label>Telephone: <input type="text" name="telephone"></label><br>
    <label>Units consumed: <input type="number" name="units_consumed" required></label><br>
    <button type="submit">Register</button>
</form>

</body>
</html>
