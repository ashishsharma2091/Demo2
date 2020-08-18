<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
   <%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration confirmation</title>
</head>
<body>
<%--< h1>spring boot form submit example</h1>
<h2> Details as submitted successfully </h2>
 <h4> User Name : ${anyObj.userName }</h4>
<h4> User Email : ${anyObj.userEmail} </h4>
<h4> User Text : ${anyObj.userText} </h4>
<h4> User Resource URI : ${anyObj.resourceURI} </h4>  --%>
<%-- <h4><a href="${'/ashish/getUserText/' + ${anyObj.userName }">View</a></h4> --%>

<c:if test="${userList.get(0).flowType=='saveConfirmation'}">
 <table class="table table-striped" border ="1">
           <thead>
            <td> <th>User ID</th>
                <th>User Name</th>
                <th>User Email</th>
                <!-- <th>User Text</th> -->
                 <th>go to user text URI</th>
                <th>Edit</th>
                <th>Delete</th>
            </td>
            <thead>
          
        <tbody>
  <c:forEach items="${userList}" var="item" varStatus="counter">
    <tr>
    <td><c:out value="${counter.count}" /></td>
    <td><c:out value="${item.userID}" /></td>
      <td><c:out value="${item.userName}" /></td>
       <td><c:out value="${item.userEmail}" /></td>
        <%-- <td><c:out value="${item.userText}" /></td> --%>
        
         <td><a href='/getUserText/<c:out value="${item.userID}"/>'>userText</a></td> 
         <td><a href='/updateUserText/<c:out value="${item.userID}"/>'>updateUser</a></td> 
        <td><a href='/deleteUser/<c:out value="${item.userID}"/>'>delete</a></td> 
    </tr>
  </c:forEach>
  </tbody>
</table>

</c:if>


<c:if test="${userList.get(0).flowType=='userTextdetails'}">
 <table class="table table-striped" border ="1">
           <thead>
            <td> <th>User ID</th>
                <th>User Name</th>
                <th>User Email</th>
                 <th>User Text</th> 
                 <th>go to user text URI</th>
                <th>Edit</th>
                <th>Delete</th>
            </td>
            <thead>
          
        <tbody>
  <c:forEach items="${userList}" var="item" varStatus="counter">
    <tr>
    <td><c:out value="${counter.count}" /></td>
    <td><c:out value="${item.userID}" /></td>
      <td><c:out value="${item.userName}" /></td>
       <td><c:out value="${item.userEmail}" /></td>
         <td><c:out value="${item.userText}" /></td> 
        
         <td><a href='/getUserText/<c:out value="${item.userID}"/>'>userText</a></td> 
         <td><a href='/updateUserText/<c:out value="${item.userID}"/>'>updateUser</a></td> 
        <td><a href='/deleteUser/<c:out value="${item.userID}"/>'>delete</a></td> 
    </tr>
  </c:forEach>
  </tbody>
</table>

</c:if>

</body>
</html>