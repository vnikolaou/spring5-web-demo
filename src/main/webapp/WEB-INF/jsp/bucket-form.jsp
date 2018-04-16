<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add bucket </title>
</head>
<body>
    <h3>Add Bucket (<c:out value="${author}"/>)</h3>
	<form:form modelAttribute="bucket" method="POST" action="addBucket.html"> 
	  <table width="300" border="0"> 
	  <tr> 
	    <td width="50%" align="left">Name: </td> 
	    <td width="50%" align="left"> 
	      <font color="red"><form:errors path="name" /></font> 
	      <form:input path="name" size="30"/> 
	    </td> 
	  </tr> 
	  <tr> 
	    <td width="50%" align="left">Zone: </td> 
	    <td width="50%" align="left"> 
	      	  <form:select path="zone" cssStyle="width:150px"> 
				  <form:options items="${zones}"/> 
				</form:select>
	    </td> 
	  </tr> 	
	  <tr> 
	    <td width="50%" align="left">Date: </td> 
	    <td width="50%" align="left"> 
	    <font color="red"><form:errors path="date" /></font> 
	      	  <form:input path="date" size="10"/> 
	    </td> 
	  </tr> 
	  <tr> 
	    <td colspan="2">
	    	<input type="submit" value="Submit"/>
	    </td> 
	  </tr> 	 
	
	  </table> 
	</form:form>
</body>
</html>