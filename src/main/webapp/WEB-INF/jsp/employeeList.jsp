<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <table>
         <tr>
             <td>Firstname</td>
             <td>Lastname</td>
             <td>Department</td>
         </tr>   
      <c:forEach var="e" items="${ employeeList }">
         <tr>
             <td><c:out value="${ e.firstName }"/></td>
             <td><c:out value="${ e.lastName }"/></td>
             <td><c:out value="${ e.deptId }"/></td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>