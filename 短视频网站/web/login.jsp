<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>短视频后天管理</title>
    <link href="../favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>

<body>
<div id="container">
    <form action="${pageContext.request.contextPath}/Login" method="post"
          id="login_form">
        <div class="login">短视频分享后台
            <span style="color:red"></span>
        </div>
        <div class="username-text">用户名:</div>
        <div class="password-text">密码:</div>
        <div class="username-field">
            <input type="text" name="adminName" value="admin"/>
        </div>
        <div class="password-field">
            <input type="password" name="password" value="123"/>
        </div>
        <input type="checkbox" name="remember-me" id="remember-me"/>
        <label for="remember-me">记住用户名</label>
        <div class="forgot-usr-pwd"></div>
        <input type="submit" name="submit" value="登录" style="font-size: 16px;margin-top:
				-1px;"/>
    </form>
</div>

</body>
</html>
