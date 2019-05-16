<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="cxtPath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="在线视频网站"/>
    <link href="${cxtPath}/css/indexMovie.css" rel='stylesheet'
          type='text/css'/>
    <link href="${cxtPath}/css/bootstrap.css" rel='stylesheet'
          type='text/css'/>
    <link href="${cxtPath}/css/style.css" rel="stylesheet" type="text/css"
          media="all"/>
    <script type="text/javascript" src="${cxtPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${cxtPath}/js/responsiveslides.min.js"></script>
    <script src="${cxtPath}/js/user.js"></script>
</head>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo" style="margin-top: -2%">
                <a href="${cxtPath}/index.jsp"><img src="${cxtPath}/images/logo.png" alt="logo"/></a>
            </div>
            <div class="col-sm-5 nav" style="margin-top: -0.5%">
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="content">
            <div class="register">
                <div class="col-md-4 login-left">
                    <h3>
                        <font color="#FFFFFF" size="5">我是老用户</font>
                    </h3>
                    <p>已有帐号</p>
                    <a class="acount-btn" href="${cxtPath}/index.jsp"><font
                            size="4">现在去登录</font></a>
                </div>
                <div class="col-md-6 login-right">
                    <h3>
                        <font color="#FFFFFF" size="6">新用户注册</font>
                    </h3>
                    <form enctype="multipart/form-data" action="${cxtPath}/userRegister" method="post"
                          onsubmit="return reCheck(this)">
                        <div>
                            <span><font color="#FFFFFF" size="4">用户名</font></span>
                            <input type="text" name="userName"
                                   id="reUserName" placeholder="请输入4到12位的用户名"/>
                            <font color="red" size="4" id="ReNameSpan"></font>
                        </div>
                        <div>
                            <span><font color="#FFFFFF" size="4">手机号码</font></span>
                            <input type="text" name="phone"
                                   id="phone" placeholder="请输入11位手机号码"/>
                            <font color="red" size="4" id="phoneSpan"></font>
                        </div>
                        <div>
								<span style="font-style: inherit;"><font color="#FFFFFF"
                                                                         size="4">密码</font></span> <input
                                type="password"
                                name="userPassword" id="userPassword" placeholder="必须包含大小写字母、数字、特殊字符"/>
                            <font color="red" size="4" id="RePassSpan"></font>
                        </div>
                        <div>
								<span style="font-style: inherit;"><font color="#FFFFFF"
                                                                         size="4">确认密码</font><label></label></span>
                            <input type="password"
                                   name="reUserPassword" id="reUserPassword" placeholder="请再次输入密码"/>
                            <font color="red" size="4" id="confirRePassSpan"></font>
                        </div>
                        <div>
								<span><font color="#FFFFFF" size="4">验证码</font>
								<font color="red" size="4" id="vodespan"></font></span>
                            <input type="text" name="vcode" id="codeid" placeholder="请输入验证码"/>
                            <img id="code" src="${cxtPath}/vcode" onclick="checkcode()">

                        </div>
                        <div style="margin-left: 20%;">
                            <input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="重置"/>
                        </div>
                        <font color="#FFFFFF" size="4" style="margin-left: 10%">注册即表示同意《
                            <a href="protocol.html" target="_blank">用户协议</a>》
                        </font>
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <footer id="footer">
        <div id="footer-3d">
            <div class="gp-container">
                <span class="first-widget-bend"></span>
            </div>
        </div>
        <div id="footer-widgets" class="gp-footer-larger-first-col">
            <div class="gp-container">
                <!--版权声明-->
                <div class="copy" align="center">
                    <p>Copyright &copy; 2015-2020</p>
                </div>
            </div>
        </div>
    </footer>
</div>
</body>
</html>