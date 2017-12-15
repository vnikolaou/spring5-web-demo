<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="myEmployee" method="POST" 
  action="addEmployee.html"> 
  <h2> 
    <center>Enter the Employee Details</center> 
  </h2> 
 
  <table width="100%" height="150" align="center" border="0"> 
  <tr> 
    <td width="50%" align="right">First name</td> 
    <td width="50%" align="left"> 
      <form:input path="firstName" size="30"/> 
    </td> 
  </tr> 
  <tr> 
    <td width="50%" align="right">Last name</td> 
    <td width="50%" align="left"> 
      <form:input path="lastName" size="30"/> 
    </td> 
  </tr> 
  <tr> 
    <td width="50%" align="right">Last name</td> 
    <td width="50%" align="left"> 
		  <form:select path="deptId"> 
		  	<form:options items="${departments}"   itemValue="deptNo" itemLabel="deptName" /> 
		  </form:select>
    </td> 
  </tr>   

  <tr> 
    <td width="50%" align="right"></td> 
    <td width="50%" align="left"> 
      <input type="submit" value="Submit" />
    </td> 
  </tr>   
  </table> 
</form:form>
</body>
</html>