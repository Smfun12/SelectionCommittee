<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <form action="#" action="@{/applyForFaculty/{facultyid}(facultyid=${faculty.facultyid})}"
          method="POST">

        <!-- Add hidden form field to handle update -->
        <input type="hidden" />

        <label for="title">Title</label>
        <input type="text" id="title" class="form-control mb-4 col-4" required>

        <label for="totalPlaces">Total places</label>
        <input type="text" id="totalPlaces" class="form-control mb-4 col-4" required>

        <label for="title">Budget Places</label>
        <input type="text" class="form-control mb-4 col-4" required>

        <label for="title">Title</label>
        <input type="text"  class="form-control mb-4 col-4" required>

        <label for="title" ></label>
        <input type="text"  class="form-control mb-4 col-4" required>

        <label for="title" ></label>
        <input type="text"  class="form-control mb-4 col-4" required>

        <label for="title" ></label>
        <input type="text" class="form-control mb-4 col-4" required>

        <button type="submit" class="btn btn-info col-2"></button>
    </form>

    <hr>

    <a href = "@{/findFaculty}"></a>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>