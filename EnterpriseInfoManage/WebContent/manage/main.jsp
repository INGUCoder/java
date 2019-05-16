<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
         <%
    String path=request.getContextPath();
    String bathPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=bathPath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业信息管理系统</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
<script type="text/javascript" src="public/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
var test = window.location.host;
var curPage=0;        //当前页
var len;            //总行数
var page;            //总页数
var pageSize = 10;    //每页显示的记录条数
var username="<%=request.getParameter("username")%>";
var userState="<%=request.getParameter("userState")%>";

	$(function(){
		$("#username").html(username);
		if(userState=="办公室"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息管理</a><a href='manage/user/user_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>系统角色管理</a><a href='manage/releasepdf/releasepdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>新公告发布</a><a href='/EnterpriseInfoManage/fileUpload/gongGao?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="邮寄登记人员"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_infoSel.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息预览</a><a href='manage/mail/mailInfo.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>邮寄信息管理</a><a href='manage/mail/mailStatistics.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>邮寄企业分区统计</a><a href='/EnterpriseInfoManage/fileUpload/gongGao?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="普查人员"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息管理</a><a href='manage/mail/mailInfoSel.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业邮寄</a><a href='/EnterpriseInfoManage/fileUpload/gongGao?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="企业负责人"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/thisEnterprise.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>本企业信息查看</a><a href='manage/consultation/consultation_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>填报咨询</a><a href='/EnterpriseInfoManage/fileUpload/gongGao?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a><a href='http://tjcx.scimall.org/?subscribe=1' class='model' style='color: white;' target='_black'>行业分类查询</a><a href='http://103.83.45.93/index1.html' class='model' style='color: white;' target='_black'>数据审核</a>"); 
		}
		
		
		$("#exit").click(function(){
			location.href="http://"+test+"/EnterpriseInfoManage/login/Login.jsp";
		})
		$("#username").click(function(){
			//location.href="http://"+test+"/LiCreaOfficialWebsite/usermanager/selectuser.jsp?username="+username;
		})
	})
</script>
<style type="text/css">
	.head{
		font-size: 28px;
		font-weight: 900;
		color: white;
		background-color:#9999CC;
		height: 60px;
	}
		
	.head_title{
		line-height:60px;
		margin-left:50px;
		float: left;
	}
	input{
		color: #66B3FF;
		background-color: white;
		font-size: 17px;
	}
	.model{ 
		margin-left: 20px;
	}
	.fenyebtn{
		font-size: 18px;
		text-align: center;
	}
	.head_model{
		font-size:20px;
		line-height:65px;
		margin-left:50px;
	}
	.page_left{
		border-right:#66B3FF solid 1px;
		float: left;
		width: 20%;
		height:600px;
	}
	.page_right{
		border-left:#66B3FF solid 3px;
		height:600px;
		float: right;
		width: 79.9%;
		background-color: #FDFFFF;
	}
	.model_list_text{
		color:#66B3FF;
		line-height:40px;
		font-weight: 900;
		font-size: 20px;
		margin-left: 80px;
		margin-top: 10px;
	}
	.page_right_head{
		background-color: #66B3FF;
		height: 40px;
		line-height: 40px;
	}
	.head_text{
		color:white;
		margin-left: 80px;
		margin-top: 20px;
		font-weight: 900;
		font-size: 20px;
	}
	.model_list_head{
		margin-left: 50px;
		margin-top: 20px;
		font-weight: 900;
		font-size: 30px;
	}
	.thead{
		background-color: #F0F0F0;
		font-weight: 600;
	}
	table{
		width: 100%;
		font-size: 18px;
		text-align: center;
	}
	td{
		border-left: white solid 1px;
	}
	tr{
		width: 80%;
		height: 40px;
	}
	.model_operation{
		border-top: #E0E0E0 solid 1px;
		border-left: #E0E0E0 solid 1px;
		border-bottom: #E0E0E0 solid 1px;
		padding-left: 20px;
	}
	.pdfPointer{
		line-height: 50px;
		font-size: 25px;
	}
</style>
</head>

<body>
	<div class="head">
		<div class="head_title">
			企业信息管理系统
		</div>
		<div class="head_model">
		</div>
	</div>
	
	<div class="head_user" style="color:#66B3FF; font-size: 17px;font-weight: 600;float: right;">
			<a style="color:#66B3FF;"  id="username"></a> |
			<span id="exit">
				<a style="color:#66B3FF;" >退出登录 </a>
			</span>
	</div>
	<br/>
	<hr/>
	<div class="model_list page_left">
		<div class="model_list_head">功能列表</div>
		<div class="model_list_text">
		</div>
	</div>
	<div class="page_right">
		<div class="page_right_head">
			<div class="head_text">
				填报指南
			</div>
		</div>
		<br/>
		<div class="pdfPointer">
			<a href="manage/guide/611.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>">1、单位基本情况611表填报手册</a>
		</div>
		<div class="pdfPointer">
			<a href="manage/guide/611-2.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>">2、从业人员情况611-2表填报手册</a>
		</div>
		<div class="pdfPointer">
			<a href="manage/guide/611-3.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>" >3、企业法人主要经济指标611-3表填报手册</a>
		</div>
		<div class="pdfPointer">
			<a href="manage/guide/611-4.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>" >4、固定资产投资611-4表填报手册</a>
		</div>
		<div class="pdfPointer">
			<a href="manage/guide/611-5.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>" target="_black">5、行政事业单位主要经济指标611-5表填报手册</a>
		</div>
		<div class="pdfPointer">
			<a href="manage/guide/611-6.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>" target="_black">6、民间非营利组织主要经济指标611-6表填报手册</a>
		</div>
		<div class="pdfPointer">
			<a href="manage/guide/611-7.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>" target="_black">7、能源消费情况BJ611-7表填报手册</a>
		</div>
	</div>
</body>
</html>