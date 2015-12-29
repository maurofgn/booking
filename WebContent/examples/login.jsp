<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<body bgcolor="#ffffff">
   <form method="POST" action="j_security_check">
   	<center>
      <table border="0">
      <tr>
      <td>Login</td>
      <td><input type="text" name="j_username"></td>
      </tr>
      <tr>
      <td>Password</td>
      <td><input type="password" name="j_password"></td>
      </tr>
      </table>
      <input type="submit" value="Login!">
      </center>
   </form>
</body>
</html>