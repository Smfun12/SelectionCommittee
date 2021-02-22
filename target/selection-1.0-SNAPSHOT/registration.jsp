<html>
<head>
    <title>Registration form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<form class="form-horizontal" action="${pageContext.request.contextPath}/app/addStudent" method="post">
    <fieldset>
        <div id="legend">
            <legend class="">Register</legend>
        </div>
        <div class="control-group">
            <!-- Username -->
            <label class="control-label">Login</label>
            <div class="controls">
                <input type="text" id="username" name="login" placeholder="" class="input-xlarge">
                <p class="help-block" >Valid login</p>
            </div>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">Email</label>
            <div class="controls">
                <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                <p class="help-block">Email</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password" >Password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                <p class="help-block" >Password</p>
            </div>
        </div>
        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="city" >City</label>
            <div class="controls">
                <input type="text" id="city" name="city" placeholder="" class="input-xlarge">
                <p class="help-block">City</p>
            </div>
        </div>
        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="district">Distrcit</label>
            <div class="controls">
                <input type="text" id="district" name="district" placeholder="" class="input-xlarge">
                <p class="help-block" >District</p>
            </div>
        </div>
        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="school">School</label>
            <div class="controls">
                <input type="text" id="school" name="school" placeholder="" class="input-xlarge">
                <p class="help-block" >School</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Register</button>
            </div>
        </div>
    </fieldset>
</form>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>