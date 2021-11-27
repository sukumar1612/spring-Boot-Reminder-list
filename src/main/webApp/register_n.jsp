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
    <!-- <form action="register_n">
        <input type="text" name="username"><br>
        <input type="text" name="password"><br>
        <input type="submit" value="register">
    </form>
    <%
         out.println("Your IP address is " + request.getRemoteAddr());
    %> -->

    <div class="login">
        <div class="form">
            <form class="login-form" action="register_n">
                <span class="material-icons">Register</span>
                <input type="text" name="username" placeholder="username" required/>
                <input type="password" name="password" placeholder="password" required />
                <button>Register</button>
            </form>
        </div>
    </div>
</body>

</html>