<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bucket List</title>
</head>
<body>
   <h3>Bucket List </h3>
   <c:out value="${dummy}"/>
   <c:if test="${message != null}"><span style="color:red"><c:out value="${message}"/></span><br/><br/></c:if>
   Author: <c:out value="${author}"/> &nbsp; <a href="addBucket.html">Add Bucket</a> <br/> <br/>
   <table border="1" width="300">
         <tr>
             <th>Id</th>
             <th>Name</th>
             <th>Zone</th>             
         </tr>   
      <c:forEach var="bucket" items="${ bucket_list }">
         <tr>
             <td><c:out value="${ bucket.id }"/></td>
             <td><c:out value="${ bucket.name }"/></td>
             <td><c:out value="${ bucket.zone }"/></td>
         </tr>
      </c:forEach>
   </table>
   <br/><br/>
   <a href="index.html"><< Home page</a> 
</body>
</html>