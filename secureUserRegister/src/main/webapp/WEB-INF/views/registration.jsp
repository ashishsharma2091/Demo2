<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
<form method="post" action="saveDetails">   
    Enter User Name : <input type="text" name="userName"/>
    Enter User Email Address: <input type="email" name="userEmail">
     Enter User Text: <input type="text" name="userText">
    <input type="submit" value="Submit">
</form>
</body>
</html>