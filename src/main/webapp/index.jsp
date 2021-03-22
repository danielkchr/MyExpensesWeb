<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>

</head>
<body>
    <div id="login-container">
        <form id="login">
            <input id="input-login" name="login" type="text">
            <input id="input-password" name="password" type="password">
            <input id="login-button" type="button" value="Login">
        </form>
    </div>

    <script>
        $("input#login-button").click(function() {
            let data = { login : document.getElementById("input-login").value, password : document.getElementById("input-password").value }

            $.post("service", data, function(result, status) {
                alert("Data: " + result + "\nStatus: " + status);
            });
        });
    </script>
<h1><%= "Hello World!" %></h1>
<br/>
<a class="test" href="secondary-servlet">Secondary Servlet</a>
</body>
</html>