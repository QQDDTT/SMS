<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员首页</title>
    <!-- <link rel="stylesheet" href="css/style.css"> -->
    <!-- <script src="js/script.js"></script> -->
    <style>
        body { font-family: Arial, sans-serif; background-color: #f3f3f3; }
        .header, .footer { background-color: #333; color: #fff; padding: 10px; text-align: center; }
        .container { max-width: 1200px; margin: 0 auto; padding: 20px; }
        .card { background-color: #fff; padding: 20px; margin-bottom: 15px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }
        .card h2 { margin: 0 0 10px; }
        .actions { display: flex; gap: 10px; flex-wrap: wrap; }
        .actions a { display: inline-block; padding: 10px 20px; color: #333; text-decoration: none; background-color: #eee; border-radius: 4px; }
        .actions a:hover { background-color: #ddd; }
    </style>
</head>
<body>
    <div class="header">
        <h1>管理员控制面板</h1>
    </div>
    <div class="container">
        <!-- 欢迎信息 -->
        <div class="card">
            <h2>欢迎, <%= request.getAttribute("adminName") %></h2>
            <p>今天是 <%= new java.text.SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date()) %></p>
        </div>

        <!-- 快捷操作 -->
        <div class="card">
            <h2>快捷操作</h2>
            <div class="actions">
                <a href="/admin/user/list">用户列表</a>
                <a href="/admin/role/list">角色列表</a>
                <a href="/admin/authority/list">权限列表</a>
            </div>
        </div>

        <!-- 系统信息 -->
        <div class="card">
            <h2>系统信息</h2>
            <p>系统当前状态：正常</p>
            <p>数据库连接：已连接</p>
            <p>在线用户数：<%= request.getAttribute("onlineUserCount") %></p>
        </div>

    </div>
    <div class="footer">
        <p>&copy; 2024 学生管理系统</p>
    </div>
</body>
</html>
