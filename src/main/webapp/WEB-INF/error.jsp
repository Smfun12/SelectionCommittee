<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="resources/static/error.css"/>
    <link rel="stylesheet" type="text/css" href="/static/error.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/error.css"/>
    <title>Error page</title>
</head>
<body>
<div class="mainbox">
    <div class="err">4</div>
    <i class="far fa-question-circle fa-spin"></i>
    <div class="err2">4</div>
    <div class="msg">
        <h2>
            Error Page<br/>
            <i>Error ${exception}</i>
        </h2>
        <a href="${pageContext.request.contextPath}">Home</a>
    </div>
</div>
</body>
</html>