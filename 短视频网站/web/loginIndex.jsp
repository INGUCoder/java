<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="#"/>
    <link type="text/css" rel="styleSheet" href="css/login.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>账号登录</title>
    <script>
        /*这里是提交表单前的非空校验*/
        $("form").submit(function () {
            let first = $("input[name='userName']").val();
            let last = $("input[name='userPassword']").val();

            if (first == "" || first == null || first == undefined) {
                return false;/*阻止表单提交*/
            } else if (last == "" || last == null || last == undefined) {
                return false;/*阻止表单提交*/
            } else {
                return true;
            }
        })
    </script>
</head>
<body>
<div id="bg">
    <div id="hint"><!-- 提示框 -->
        <p>登录失败</p>
    </div>
    <div id="login_wrap">
        <div id="login"><!-- 登录注册切换动画 -->
            <div id="status">
                <i style="top: 0">登录</i>
                <i style="top: 35px">注册</i>
                <!--<i style="right: -2px">in</i>-->
            </div>
            <span>
                    <form action="/userLogin" method="post">
                        <p class="form"><input type="text" id="user" name="userName" placeholder="昵称"></p>
                        <p class="form"><input type="password" id="passwd" name="userPassword" placeholder="密码"></p>
                        <p class="form confirm"><input type="password" id="confirm-passwd"
                                                       placeholder="confirm password"></p>
                        <input type="submit" value="登录" class="btn">
                        <input type="button" value="注册" class="btn" onclick='signin()'>
                    </form>
                </span>
        </div>

        <div id="login_img"><!-- 图片绘制框 -->
            <span class="circle">
                    <span></span>
                    <span></span>
                </span>
            <span class="star">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </span>
            <span class="fly_star">
                    <span></span>
                    <span></span>
                </span>
            <p id="title"> video</p>
        </div>
    </div>
</div>
</body>
<script src="js/login.js">
</script>

</html>
