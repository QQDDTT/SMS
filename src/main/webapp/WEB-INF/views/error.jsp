<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>错误页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #c0392b;
        }
        .error-message {
            border: 1px solid #c0392b;
            background-color: #f9e1e1;
            padding: 20px;
            margin: 20px auto;
            width: 80%;
            max-width: 600px;
            border-radius: 5px;
        }
        a {
            text-decoration: none;
            color: #2980b9;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h1>发生错误</h1>
    <div class="error-message">
        <p>抱歉，您访问的页面出现了问题。</p>
        <p>错误信息: <%= exception.getMessage() %></p>
        <p>请尝试返回 <a href="${pageContext.request.contextPath}/">首页</a> 或联系客服。</p>
    </div>

</body>
</html>
