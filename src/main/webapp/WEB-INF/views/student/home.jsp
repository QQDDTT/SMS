<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户主页</title>
    <!-- <link rel="stylesheet" href="styles.css"> -->
</head>
<body>
<div class="container">
    <header>
        <h1>欢迎, <%= request.getAttribute("userName") %></h1>
    </header>

    <!-- 用户基本信息 -->
    <section class="user-info">
        <h2>个人信息</h2>
        <ul>
            <li><strong>用户名:</strong> <%= request.getAttribute("userName") %></li>
            <li><strong>邮箱:</strong> <%= request.getAttribute("userEmail") %></li>
            <li><strong>电话:</strong> <%= request.getAttribute("userPhone") %></li>
            <li><strong>地址:</strong> <%= request.getAttribute("userAddress") %></li>
        </ul>
    </section>

    <!-- 通知内容 -->
    <section class="announcements">
        <h2>最新通知</h2>
        <%
            List<Announcement> announcements = (List<Announcement>) request.getAttribute("announcements");
            if (announcements != null) {
                for (Announcement announcement : announcements) {
        %>
            <div class="announcement">
                <h3><%= announcement.getTitle() %></h3>
                <p><%= announcement.getContent() %></p>
                <p><small>发布于: <%= announcement.getDate() %></small></p>
            </div>
        <%
                }
            } else {
        %>
            <p>暂无通知</p>
        <%
            }
        %>
    </section>
</div>
</body>
</html>
