<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="message" />
<html lang="${param.lang}">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-default navbar-fixed-top">
        <a class="navbar-brand" href="" ><span><fmt:message key="nav"/></span></a>
        <a class="nav-link" href="${pageContext.request.contextPath}/app/facultyList?currentPage=1&recordsPerPage=5"><span><fmt:message key="faculties"/></span></a>
        <a class="nav-link" href="${pageContext.request.contextPath}/app/studentList"><span><fmt:message key="students"/></span></a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/app/facultyList"><span><fmt:message key="faculties"/></span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/app/studentList" ><span><fmt:message key="students"/></span></a>
                </li>
            </ul>
        </div>
        <form action="${pageContext.request.contextPath}/app/registration">
            <button type="submit" class="btn btn-info"><span><fmt:message key="sign_up"/></span></button>
        </form>
        <a class="nav-link" href="?lang=en">
            <img src="static/united-kingdom.png"/>English
        </a>
        <a class="nav-link" href="?lang=ua">
            <img src="static/ukraine.png"/>Ukraine
        </a>
    </nav>

    <div>
        <div class="div1">
            <img src="${pageContext.request.contextPath}/static/naukma_photo.jpg" alt="bg" class="back-image">
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>



    </body>
</html>
