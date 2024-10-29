<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        .login-container {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: 0 auto;
        }
        h2 {
            color: #5a5a5a;
        }
        .error-message {
            color: red;
            margin-bottom: 15px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>登录</h2>
    <!-- 显示错误消息 -->
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <div class="error-message"><%= error %></div>
    <% } %>
    <form action="/login" method="post">
        <p>用户名</p>
        <input type="text" name="name"/>
        <p>密码</p>
        <input type="password" name="password"/>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
