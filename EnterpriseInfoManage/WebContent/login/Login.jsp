<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/" + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录企业信息管理系统</title>
<script type="text/javascript" src="../public/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){//加载事件
		$("#login_btn").click(function(){
			login();
		});
	});
	function login(){
		location.href='/EnterpriseInfoManage/loginController/loginValidate?userName='+$("#username").val()+'&userpwd='+$("#userpwd").val();	
	}
</script>
<style>
	body {
    scrollbar-face-color: #ededf3;
    scrollbar-highlight-color: #ffffff;
    scrollbar-shadow-color: #93949f;
    scrollbar-3dlight-color: #ededf3;
    scrollbar-arrow-color: #082468;
    scrollbar-track-color: #f7f7f9;
    scrollbar-darkshadow-color: #ededf3;
    font-size: 9pt; /*www.52css.com*/
    color: blue;
    overflow:auto;
}


#username,#userpwd{
    background: #ffffff;
    border: 1px solid #b7b7b7;
    color: #003366;
    cursor: text;
    font-family: "arial";
    font-size: 9pt;
    height: 18px;
    padding: 1px; /*www.52css.com*/
}

	#login_btn{
	 font-family: "tahoma", "宋体"; /*www.52css.com*/
    font-size:9pt; color: #003399;
    border: 1px #003399 solid;
    color:#006699;
    border-bottom: #93bee2 1px solid;
    border-left: #93bee2 1px solid;
    border-right: #93bee2 1px solid;
    border-top: #93bee2 1px solid;
    background-image:url(../images/bluebuttonbg.gif);
    background-color: #e8f4ff;
    cursor: hand;
    font-style: normal ;
    width:80px;
    height:30px;
}

</style>
</head>
<body>
	<center>
	<br/><br/><br/><br/>
		<h1>企业信息管理系统</h1>
		<br/><br/><br/>
		用户名：<input id="username" type="text"/><br/><br/>
		密&nbsp;&nbsp;&nbsp;码：<input id="userpwd" type="password"/><br/><br/><br/>
		<input type="button" id="login_btn" value="登录"/>
	</center>
</body>
</html>