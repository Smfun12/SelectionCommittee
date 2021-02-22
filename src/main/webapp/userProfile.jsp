<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/profile.css">
    <title>Title</title>
</head>
<body><nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-default navbar-fixed-top">
    <a class="navbar-brand"  href="${pageContext.request.contextPath}" >Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link"  href="${pageContext.request.contextPath}"><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/findFaculty" > <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/findStudent"></a>
            </li>
        </ul>
    </div>
    <div  class="logout">
        <span style="color: red;font-size: 20px;"></span>
        <a  href="${pageContext.request.contextPath}" style="color: red;font-size: 20px;"></a>

        <form action="#" action="/" method="post">
            <input type="submit" class="btn btn-info"  value="#{logout}" />
        </form>
    </div>
    <form  action="@{/login}"  >
        <button type="submit"  text="#{sign_in}"></button>
    </form>
    <form  action="@{/registration}">
        <button type="submit" class="btn btn-info"  text="#{sign_up}"></button>
    </form>
    <a class="nav-link"  href="@{?localeData=en}">
        <img  src="@{/static/united-kingdom.png}"/>English
    </a>
    <a class="nav-link"  href="@{?localeData=ua}">
        <img  src="@{/static/ukraine.png}"/>Ukraine
    </a>
</nav>
<div class="container">
    <div class="main-body">

        <!-- Breadcrumb -->
        <!-- /Breadcrumb -->

        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                        </div>
                    </div>
                </div>
                <div class="card mt-3">
                    <tr  each="faculty : ${student.faculties}">
                        <td><span  text="${faculty.title}"></span></td>
                    </tr>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Login</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <span  text="${login}"></span>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <span  text="${email}"></span>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">1st Mark</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <p  text="${firstGrade}">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">2nd Mark</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <p  text="${secondGrade}">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">3rd Mark</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <p  text="${thirdGrade}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>