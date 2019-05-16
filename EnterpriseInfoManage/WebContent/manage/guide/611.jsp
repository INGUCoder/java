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
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息管理</a><a href='manage/user/user_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>系统角色管理</a><a href='manage/releasepdf/releasepdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>新公告发布</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="邮寄登记人员"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_infoSel.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息预览</a><a href='manage/mail/mailInfo.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>邮寄信息管理</a><a href='manage/mail/mailStatistics.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>邮寄企业分区统计</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="普查人员"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息管理</a><a href='manage/user/user_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>系统角色管理</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="企业负责人"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业信息管理</a><a href='manage/user/user_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>系统角色管理</a><a href='manage/consultation/consultation_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>填报咨询</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
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
		overflow-y:auto;
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
				<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">
								<b>A 法人单位和产业活动单位基本情况</b>
							</h3>
						</div>
						<div class="panel-body">
							<ul>
								<li>109 统一社会信用代码：根据证照填写，若无信用代码，则填写组织机构代码</li>
								<li>102 单位详细名称：按证照填写</li>
								<li>201 法定代表人（单位负责人）：按证照填写</li>
								<li>202 开业（成立）时间：可追溯的最早成立时间</li>
								<li>105 单位所在地及区划：乡（镇）、街道办事处必须且其中只能填写一项,需要详细说明所在地址，精确到门牌号</li>
								<li>106 单位注册地及区划：根据证照中的“住所”填写，不要漏填</li>
								<li>103 行业类别：按照主要业务活动的收入占比或重要程度依次填写1-3项；“动词”+“名词”/ “名词”+ “动词”，请勿照抄营业执照，如“技术开发”、“技术服务”等，“销售”需区分“批发”还是“零售”，勿出现标点符号，字符数勿超过十个；</li>
								<li>205 登记注册类型：企业单位参照《营业执照》中的“类型”填写或问询企业注册时的投资人情况；非企业单位依据单位的主要经费来源和管理方式填写</li>
						
							</ul>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">
								<b>B 批发和零售业、住宿和餐饮业法人和产业活动单位填报</b>
							</h3>
						</div>
						<div class="panel-body">
							<ul>
								<li>ES1 批发和零售业、住宿和餐饮业单位经营形式：连锁总店、连锁直营店、连锁加盟店填写连锁品牌（商标或商号名称）</li>
								<li>E02 零售业态：可选三项，可跨有店铺零售、无店铺零售多选</li>
								<li>S03 住宿和餐饮业年末餐饮营业面积：旅游委认定的面积</li>
							</ul>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">
								<b>C 法人单位填报</b>
							</h3>
						</div>
						<div class="panel-body">
							<ul>
								<li>216 港澳台商投资情况：限登记注册类型为港澳台商投资单位填报</li>
								<li>206 企业控股情况：按法人资本的实际情况判断，注意登记注册类型与控股关系关联</li>
								<li>214 法人单位的上级法人单位情况：限企业、参照企业管理的事业单位填报；机关、事业单位填“否”；上一级法人单位在境外（含港澳台）填“否”；填“是”需补充611-1表</li>
							</ul>
						</div>
					</div>
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">
								<b>D 产业活动单位归属法人情况及主要经济指标（此部分只有产业活动单位填报）</b>
							</h3>
						</div>
						<div class="panel-body">
							<ul>
								<li>198 从业人员期末人数：指报告期最后一日与本单位存在劳动关系，并取得工资或其他形式劳动报酬的人员数，包括在岗职工+劳务派遣人员+其他从业人员，不包括离开本单位但仍保留劳动关系，定期领取生活费人员、学校实习生、劳务外包形式使用的人员</li>
								<li>195 经营性单位收入：经营性产业活动单位填写其全年生产经营活动取得的收入</li>
								<li>196 非经营性单位支出（费用）：行政事业单位填写日常业务支出，其他单位填写各种费用合计</li>
						
							</ul>
						</div>
					</div>
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h3 class="panel-title">
								<b>免填指标</b>
							</h3>
						</div>
						<div class="panel-body">
							<ul>
								<li>111普查小区代码  112建筑物编码  113底册唯一标识码  114专业类别</li>
								<li>105、106园区企业所属园区详细名称</li>
								<li>103行业代码  191单位规模  192从业人员期末人数  193企业法人单位填报</li>
								<li>194非企业法人单位填报  182法人单位区划代码</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		
	</div>
</body>
</html>