<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="home.css">
</head>

<body>
    <!-- <script src="" async defer></script>
    <form action="loginUser">
        <input type="text" name="username"><br>
        <input type="text" name="password"><br>
        <input type="submit" value="login">
    </form>
    <form action="/register">
        <input type="submit" value="Register">
    </form> -->


    <div class="login">
        <div class="form">
            <form class="login-form" action="loginUser">
                <span class="material-icons">login</span>
                <input type="text" name="username" placeholder="username" required/>
                <input type="password" name="password" placeholder="password" required />
                <button>login</button>
            </form>
            <br>
            <form action="/register">
                <button type="submit">Register</button>
            </form>
        </div>
    </div>
</body>

</html>