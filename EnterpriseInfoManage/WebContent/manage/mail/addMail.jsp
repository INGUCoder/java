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
var username="<%=request.getParameter("username")%>"
var userState="<%=request.getParameter("userState")%>";
	$(function(){
		$("#username").html(username);
		$("#exit").click(function(){
			location.href="http://"+test+"/EnterpriseInfoManage/login/Login.jsp";
		})
		Loading();
		$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;'>首页</a><a href='manage/enterprise/enterprise_infoSel.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息预览</a><a href='manage/mail/mailInfo.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;background-color:#5B00AE'>邮寄信息管理</a><a href='manage/mail/mailStatistics.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>邮寄企业分区统计</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		$("#add").click(function(){
   			var mailerTelephone=$("#mailerTelephone").val();
   			var mailerName=$("#mailerName").val();
   			var mailTime=$("#mailTime").val();
   			var mailNumber=$("#mailNumber").val();
			if(mailerTelephone==""||mailerName==""||mailTime==""||mailNumber==""){
				alert("请将信息填充完整");
				return false;
			}
			addMail();
		})
	})
	
	function Loading() {
		$.ajax({
			type:"post",
			url:"http://"+test+"/EnterpriseInfoManage/enterpriseInfoController/getAllEnterprise",
			data:"json",
			success:function(data){
				var st="<option value='-1'>-请选择-</option>";
				$.each(data,function(index,item){
					st+="<option value='"+item.enterpriseId+"'>"+item.enterpriseDetailedName+"</option>";
				});
				$("#enterpriseid").html(st);
			}
		})
	}
	function addMail(){
	  	$.ajax({
       		async:false,
       		type:"post",
       		url:"http://"+test+"/EnterpriseInfoManage/mailInfoController/addMail",
       		dataType: "json",
       		data:{
       			enterpriseId:$("#enterpriseid").val(),
       			mailerTelephone:$("#mailerTelephone").val(),
       			mailerName:$("#mailerName").val(),
       			mailTime:$("#mailTime").val(),
       			mailNumber:$("#mailNumber").val()
       		},
       		success:function(data){
       			if(data>0){
       				alert("添加成功");
       			}
       		}
       	})
		
	}
	
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
		color: gray;
		background-color: white;
		font-size: 17px;
	}
	.model{ 
		margin-left: 20px;
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
		height:500px;
	}
	.page_right{
		border-left:#66B3FF solid 3px;
		height:500px;
		float: right;
		width: 79.9%;
		overflow-y:auto;
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
		color:black;
		margin-left: 80px;
		margin-top: 20px;
		font-weight: 900;
		font-size: 30px;
	}
	.model_list_head{
		margin-left: 50px;
		margin-top: 20px;
		font-weight: 900;
		font-size: 30px;
	}
	#body_text{
		font-size: 18px;
	}
	.model_operation{
		border-top: #E0E0E0 solid 1px;
		border-left: #E0E0E0 solid 1px;
		border-bottom: #E0E0E0 solid 1px;
		padding-left: 20px;
	}
	.page_right_body{
		height: 40px
	}
	table{
		border:1px #E0E0E0 solid;
		width: 500px;
		height:500px;
	}
	tbody{
		text-align: center;
		}
	td{
		float:left;
		padding-left: 40px;
	}	
	tr{
		margin-top: 20px
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
			<a href="add/addClasses.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>"><div class="model_operation model_list_add">添加</div></a><hr/>
			<a href="javascript:history.back(-1)"><div class="model_operation model_list_get">查看</div></a>
		</div>
	</div>
	<div class="page_right" align="center">
	<table>
		<thead>
			<tr class="head_text"  height="50px"><td colspan="2" style="padding-left: 130px">添加邮寄信息</td></tr><br/><br/>
		</thead>
		<tbody>		
			<tr class="page_right_body">
				<td><span id="body_text">邮寄企业</span><select id="enterpriseid">
				</select></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">邮寄人电话:</span><input id="mailerTelephone"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">邮寄人名称:</span><input id="mailerName"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">邮寄时间:</span><input id="mailTime"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">邮寄单号:</span><input id="mailNumber"/></td>
			</tr>
		</tbody>
	
		<tfoot>
		<tr class="page_right_foot" align="center">
			<td colspan="2" style="padding-left: 100px;"><input type="button" id="add" value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" name="button1" id="button1" value="取消" onclick="history.go(-1)"></td>
		</tr>
		</tfoot>
	</table>
	</div>
</body>
</html>