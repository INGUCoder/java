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
var curriculumsystemid="<%=request.getParameter("curriculumsystemid")%>"
var curPage=0;        //当前页
var len;            //总行数
var page;            //总页数
var pageSize = 10;    //每页显示的记录条数
var username="<%=request.getParameter("username")%>";
var userState="<%=request.getParameter("userState")%>";
	$(function(){
		$("#username").html(username);
		$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;'>首页</a><a href='manage/enterprise/thisEnterprise.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;background-color:#5B00AE'>本企业信息查看</a><a href='manage/consultation/consultation_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>填报咨询</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a><a href='http://tjcx.scimall.org/?subscribe=1' class='model' style='color: white;' target='_black'>行业分类查询</a><a href='http://103.83.45.93/index1.html' class='model' style='color: white;' target='_black'>数据审核</a>"); 
		$("#exit").click(function(){
			location.href="http://"+test+"/EnterpriseInfoManage/login/Login.jsp";
		})
	        loding();
	})
	

	function loding(pageNum){
		var id=0;
		$.ajax({
			async:false,
			type:"post",
			url:"http://"+test+"/EnterpriseInfoManage/userController/getByUserName?username="+username,
			dataType:"json",
			success:function(data){
				id=data;
			}
		})
		$.ajax({
			async:false,
			type:"post",
			url:"http://"+test+"/EnterpriseInfoManage/enterpriseInfoController/selectById?enterpriseId="+id,
			dataType:"json",
			success:function(data){
				var html ="";
					html +="<tr><td>"+data.enterpriseZoningDivision+"</td><td>"+data.enterpriseUnifiedSocialCreditCode+"</td><td>"+data.enterpriseOrganizationalCode+"</td><td>"+data.enterpriseDetailedName+"</td><td>"+data.enterpriseLegalRepresentative+"</td><td>"+data.enterpriseAddressStatus+"</td><td>"+data.enterpriseDetailedAddress+"</td><td>"+data.enterpriseMobilePhone+"</td><td>"+data.enterpriseBusinessActivities+"</td><td>"+data.enterpriseIndustryCode+"</td><td>"+data.enterpriseRegistrationTypes+"</td><td>"+data.enterpriseIsHaveBranchOffice+"</td><td>"+data.enterpriseArea+"</td><td>"+data._611+"</td><td>"+data._6111+"</td><td>"+data._6112+"</td><td>"+data._6113+"</td><td>"+data._61144+"</td><td>"+data._6115+"</td><td>"+data._6116+"</td><td>"+data._61177+"</td><td>"+data.enterpriseEnergyConsumption+"</td><td>"+data.enterpriseInvestmentFixedAssets+"</td><td>"+data.enterpriseRegistrationType+"</td><td>"+data.enterpriseOperationState+"</td><td>"+data.enterpriseRegistrationStatus+"</td><td>"+data.enterpriseSupplementaryItems+"</td></tr>";
				$(".tbody").html(html);
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
		white-space: nowrap;
	}
	td{
		border: #E5DFDA solid 1px;
		padding:5px; 
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
	.page_right_body{
		overflow:scroll;
	}
	table{
		
	}
	td{
		word-break: break-all; word-wrap:break-word;
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
			</div>
		</div>
		<br/>
		<div class="model_select" align="center" style="color: gray">
		</div>
		<br/><br/>
		<div class="page_right_body">
			<div class="body">
				<table>
					<thead class="thead">
						<tr>
							<td>底册区划</td>
							<td>统一社会信用代码</td>
							<td>组织机构代码</td>
							<td>单位详细名称</td>
							<td>法定代表人</td>
							<td>企业地址状态</td>
							<td>单位所在地街村门牌号</td>
							<td>移动电话</td>
							<td>核实后主要业务活动</td>
							<td>核实后行业代码</td>
							<td>登记注册类型</td>
							<td>是否有下属产业活动单位</td>
							<td>企业区域</td>
							<td>611</td>
							<td>611-1</td>
							<td>611-2</td>
							<td>611-3</td>
							<td>611-4-4</td>
							<td>611-5</td>
							<td>611-6</td>
							<td>611-7-7</td>
							<td>消耗能源</td>
							<td>投资固定资产</td>
							<td>企业登记类型</td>
							<td>运营状态</td>
							<td>企业登记状态</td>
							<td>企业补充项</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody class="tbody">
						
					</tbody>
				</table>
				<hr/>
				<div class="fenyebtn">
				</div>
			</div>
		</div>
	</div>
</body>
</html>