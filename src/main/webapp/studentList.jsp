<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="message"/>
<html lang="${param.lang}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-default navbar-fixed-top">
    <a class="navbar-brand" href="${pageContext.request.contextPath}"><span><fmt:message key="nav"/></span></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/app/facultyList?currentPage=1&recordsPerPage=5&sortBy=facultyid&order=asc"><span><fmt:message
                        key="faculties"/></span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/app/studentList?currentPage=1&recordsPerPage=5&sortBy=studentid&order=asc"><span><fmt:message
                        key="students"/></span></a>
            </li>
        </ul>
    </div>
    <a class="nav-link" href="?lang=en">
        <img src="static/united-kingdom.png"/>English
    </a>
    <a class="nav-link" href="?lang=ua">
        <img src="static/ukraine.png"/>Ukraine
    </a>
</nav>
<h2>
    List Students <br/>
</h2>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">
            #
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=studentid&order=desc">↓</a>
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=studentid&order=asc">↑</a>

        </th>
        <th scope="col">
            Login
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=login&order=desc">↓</a>
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=login&order=asc">↑</a>

        </th>
        <th scope="col">
            Email
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=email&order=desc">↓</a>
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=email&order=asc">↑</a>

        </th>
        <th scope="col">
            City
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=city&order=desc">↓</a>
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=city&order=asc">↑</a>

        </th>
        <th scope="col">
            District
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=district&order=desc">↓</a>
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=district&order=asc">↑</a>

        </th>
        <th scope="col">
            School
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=school&order=desc">↓</a>
            <a href="${pageContext.request.contextPath}/app/studentList?currentPage=${currentPage}&recordsPerPage=${total}&sortBy=school&order=asc">↑</a>

        </th>
        <th scope="col">Role</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
    <tr>
        <th scope="row"><span>${student.id}</span></th>
        <td>${student.login}</td>
        <td>${student.email}</td>
        <td>${student.city}</td>
        <td>${student.district}</td>
        <td>${student.school}</td>
        <td></td>
        <td>
            <a href="${pageContext.request.contextPath}/app/showEditStudentPage?id=${student.id}"
               class="btn btn-info"> <fmt:message key="update"/></a>
            <a href="${pageContext.request.contextPath}/app/deleteStudent?id=${student.id}"
            class="btn btn-info"> <fmt:message key="delete"/></a>
        </td>
        </c:forEach>
    </tr>

    </tbody>

</table>
<nav aria-label="Navigation for countries">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/app/studentList?recordsPerPage=${total}&tPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/app/studentList?recordsPerPage=${total}&tPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/app/studentList?recordsPerPage=${total}&tPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
