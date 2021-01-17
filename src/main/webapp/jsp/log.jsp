<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 10.01.2021
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <title>Neon Chess &#9819;</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--jquery-->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

    <!--icons-->
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <!--CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/log.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<div class="login-box">
    <h2>Login</h2>
    <p style="color: red">${mess}</p>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <!--email-->
        <div class="user-box">
            <input type="text" name="email">
            <label>Email</label>
        </div>

        <!--password-->
        <div class="user-box">
            <input type="password" name="password">
            <label>Password</label>
        </div>

        <!--radio chess color-->
        <div class="col">
            <p style="color: #FEC061;">Choose chess color</p>
            <div class="row d-flex justify-content-around">
                <div>
                    <input type="radio" name="chess" checked value="white">
                    <label style="color: white;">&#9819;</label>
                </div>
                <div>
                    <input type="radio" name="chess" value="black">
                    <label>&#9819;</label>
                </div>

            </div>

        </div>

        <!--submit or enter button-->
        <a>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <button type="submit">Start Game</button>
        </a>

    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>