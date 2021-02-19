<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Student Management System</h1>
    <hr>
    <h2>Update Student</h2>

    <form action="${pageContext.request.contextPath}/app/editStudent"
          method="post">

        <!-- Add hidden form field to handle update -->
        <input type="hidden" name="id" value="${id}"/>

        <input type="text" name="login" value="${login}" class="form-control mb-4 col-4">

        <input type="text" name="email" value="${email}" class="form-control mb-4 col-4">

        <input type="hidden" name="password" value="${password}" class="form-control mb-4 col-4">

        <input type="text" name="city" value="${city}" class="form-control mb-4 col-4">

        <input type="text" name="district" value="${district}" class="form-control mb-4 col-4">

        <input type="text" name="school" value="${school}" class="form-control mb-4 col-4">

        <button class="btn btn-info col-2"> Update Student</button>
    </form>

    <hr>

    <a href = "${pageContext.request.contextPath}/app/studentList"> Back to Find List</a>
</div>
</body>
</html>