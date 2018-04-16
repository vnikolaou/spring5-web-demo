<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" href="/s3/<spring:theme code='styleSheet'/>"/>
<script src= "webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>AWS Demo</h3>
<br/>
    <fm:form method="post" action="/s3/index.html"  modelAttribute="formData">
     <fm:select path="language">
        <fm:options items="${locales}"/>
     </fm:select>
     <fm:select path="theme">
        <fm:options items="${themes}"/>
     </fm:select>     
     <input type="submit" value="Change" />
    </fm:form><br/>
    
<spring:message code="hello" /><br/>
<a href="buckets.html">Show buckets</a> <c:out value="${dummy}"/>
<br/>
<a href="upload.html">Show Upload</a> 
</body>
</html>