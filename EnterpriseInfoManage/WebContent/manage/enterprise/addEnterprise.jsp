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
		$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;background-color:#5B00AE'>企业信息管理</a><a href='manage/user/user_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>系统角色管理</a><a href='manage/releasepdf/releasepdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>新公告发布</a>");
		$("#add").click(function(){
			var enterpriseZoningDivision=$("#enterpriseZoningDivision").val();
   			var enterpriseUnifiedSocialCreditCode=$("#enterpriseUnifiedSocialCreditCode").val();
   			var enterpriseOrganizationalCode=$("#enterpriseOrganizationalCode").val();
   			var enterpriseDetailedName=$("#enterpriseDetailedName").val();
   			var enterpriseLegalRepresentative=$("#enterpriseLegalRepresentative").val();
   			var enterpriseAddressStatus=$("#enterpriseAddressStatus").val();
   			var enterpriseDetailedAddress=$("#enterpriseDetailedAddress").val();
   			var enterpriseMobilePhone=$("#enterpriseMobilePhone").val();
   			var enterpriseBusinessActivities=$("#enterpriseBusinessActivities").val();
   			var enterpriseIndustryCode=$("#enterpriseIndustryCode").val();
   			var enterpriseRegistrationTypes=$("#enterpriseRegistrationTypes").val();
   			var enterpriseIsHaveBranchOffice=$("#enterpriseIsHaveBranchOffice").val();
   			var enterpriseArea=$("#enterpriseArea").val();
   			var _611=$("#_611").val();
   			var _6111=$("#_6111").val();
   			var _6112=$("#_6112").val();
   			var _6113=$("#_6113").val();
   			var _61144=$("#_61144").val();
   			var _6115=$("#_6115").val();
   			var _6116=$("#_6116").val();
   			var _61177=$("#_61177").val();
   			var enterpriseEnergyConsumption=$("#enterpriseEnergyConsumption").val();
   			var enterpriseInvestmentFixedAssets=$("#enterpriseInvestmentFixedAssets").val();
   			var enterpriseRegistrationType=$("#enterpriseRegistrationType").val();
   			var enterpriseOperationState=$("#enterpriseOperationState").val();
   			var enterpriseRegistrationStatus=$("#enterpriseRegistrationStatus").val();
   			var enterpriseSupplementaryItems=$("#enterpriseSupplementaryItems").val();
			if(enterpriseZoningDivision==""||enterpriseUnifiedSocialCreditCode==""||enterpriseOrganizationalCode==""||enterpriseDetailedName==""||enterpriseLegalRepresentative==""||enterpriseAddressStatus==""||enterpriseDetailedAddress==""||enterpriseMobilePhone==""||enterpriseBusinessActivities==""||enterpriseIndustryCode==""||enterpriseRegistrationTypes==""||enterpriseIsHaveBranchOffice==""||enterpriseArea==""||_611==""||_6111==""||_6112==""||_6113==""||_61144==""||_6115==""||_6116==""||_61177==""||enterpriseEnergyConsumption==""||enterpriseInvestmentFixedAssets==""||enterpriseRegistrationType==""||enterpriseOperationState==""||enterpriseRegistrationStatus==""||enterpriseSupplementaryItems==""){
				alert("请将信息填充完整");
				return false;
			}
			addEnterprise();
		})
	})
	function addEnterprise(){
	alert($("#_611").val()+"ll");
	  	$.ajax({
       		async:false,
       		type:"post",
       		url:"http://"+test+"/EnterpriseInfoManage/enterpriseInfoController/addEnterprise",
       		dataType: "json",
       		data:{
       			enterpriseZoningDivision:$("#enterpriseZoningDivision").val(),
       			enterpriseUnifiedSocialCreditCode:$("#enterpriseUnifiedSocialCreditCode").val(),
       			enterpriseOrganizationalCode:$("#enterpriseOrganizationalCode").val(),
       			enterpriseDetailedName:$("#enterpriseDetailedName").val(),
       			enterpriseLegalRepresentative:$("#enterpriseLegalRepresentative").val(),
       			enterpriseAddressStatus:$("#enterpriseAddressStatus").val(),
       			enterpriseDetailedAddress:$("#enterpriseDetailedAddress").val(),
       			enterpriseMobilePhone:$("#enterpriseMobilePhone").val(),
       			enterpriseBusinessActivities:$("#enterpriseBusinessActivities").val(),
       			enterpriseIndustryCode:$("#enterpriseIndustryCode").val(),
       			enterpriseRegistrationTypes:$("#enterpriseRegistrationTypes").val(),
       			enterpriseIsHaveBranchOffice:$("#enterpriseIsHaveBranchOffice").val(),
       			enterpriseArea:$("#enterpriseArea").val(),
       			_611:$("#_611").val(),
       			_6111:$("#_6111").val(),
       			_6112:$("#_6112").val(),
       			_6113:$("#_6113").val(),
       			_61144:$("#_61144").val(),
       			_6115:$("#_6115").val(),
       			_6116:$("#_6116").val(),
       			_61177:$("#_61177").val(),
       			enterpriseEnergyConsumption:$("#enterpriseEnergyConsumption").val(),
       			enterpriseInvestmentFixedAssets:$("#enterpriseInvestmentFixedAssets").val(),
       			enterpriseRegistrationType:$("#enterpriseRegistrationType").val(),
       			enterpriseOperationState:$("#enterpriseOperationState").val(),
       			enterpriseRegistrationStatus:$("#enterpriseRegistrationStatus").val(),
       			enterpriseSupplementaryItems:$("#enterpriseSupplementaryItems").val()
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
			<tr class="head_text"  height="50px"><td colspan="2" style="padding-left: 130px">添加企业信息</td></tr><br/><br/>
		</thead>
		<tbody>		
			<tr class="page_right_body">
				<td><span id="body_text">底&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;&nbsp;&nbsp;&nbsp;区&nbsp;&nbsp;&nbsp;&nbsp;划:</span><input id="enterpriseZoningDivision"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">统一社会信用代码:</span><input id="enterpriseUnifiedSocialCreditCode"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">组&nbsp;织&nbsp;机&nbsp;构&nbsp;代&nbsp;码:</span><input id="enterpriseOrganizationalCode"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">单&nbsp;位&nbsp;详&nbsp;细&nbsp;名&nbsp;称:</span><input id="enterpriseDetailedName"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">法&nbsp;&nbsp;定&nbsp;&nbsp;代&nbsp;&nbsp;表&nbsp;&nbsp;人:</span><input id="enterpriseLegalRepresentative"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">企&nbsp;业&nbsp;地&nbsp;址&nbsp;状&nbsp;态:</span><input id="enterpriseAddressStatus"/></td>
			</tr>
			
			<tr class="page_right_body">
				<td><span id="body_text">单&nbsp;位&nbsp;详&nbsp;细&nbsp;地&nbsp;址:</span><input id="enterpriseDetailedAddress"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">移&nbsp;&nbsp;&nbsp;动&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;&nbsp;话:</span><input id="enterpriseMobilePhone"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">核实后主要业务:</span><input id="enterpriseBusinessActivities"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">核实后行业代码:</span><input id="enterpriseIndustryCode"/></td>
			</tr>
	
			<tr class="page_right_body">
				<td><span id="body_text">登&nbsp;记&nbsp;注&nbsp;册&nbsp;类&nbsp;型:</span><input id="enterpriseRegistrationTypes"/>
				</td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">是&nbsp;否&nbsp;有&nbsp;分&nbsp;公&nbsp;司:</span><input id="enterpriseIsHaveBranchOffice"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">企&nbsp;&nbsp;&nbsp;业&nbsp;&nbsp;&nbsp;区&nbsp;&nbsp;&nbsp;域:</span><input id="enterpriseArea"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611:</span><input id="_611"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-1:</span><input id="_6111"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-2:</span><input id="_6112"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-3:</span><input id="_6113"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-4-4:</span><input id="_61144"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-5:</span><input id="_6115"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-6:</span><input id="_6116"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">611-7-7:</span><input id="_61177"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">消&nbsp;&nbsp;&nbsp;耗&nbsp;&nbsp;&nbsp;能&nbsp;&nbsp;&nbsp;源:</span><input id="enterpriseEnergyConsumption"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">投&nbsp;资&nbsp;固&nbsp;定&nbsp;资&nbsp;产:</span><input id="enterpriseInvestmentFixedAssets"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">企&nbsp;业&nbsp;登&nbsp;记&nbsp;类&nbsp;型:</span><input id="enterpriseRegistrationType"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">运&nbsp;&nbsp;&nbsp;营&nbsp;&nbsp;&nbsp;状&nbsp;&nbsp;&nbsp;态:</span><input id="enterpriseOperationState"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">企&nbsp;业&nbsp;登&nbsp;记&nbsp;状&nbsp;态:</span><input id="enterpriseRegistrationStatus"/></td>
			</tr>
			<tr class="page_right_body">
				<td><span id="body_text">企&nbsp;&nbsp;业&nbsp;&nbsp;补&nbsp;&nbsp;充&nbsp;&nbsp;项:</span><input id="enterpriseSupplementaryItems"/></td>
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