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
					
						<div class="tabbable" id="tabs-836087">
							<ul class="nav nav-tabs">
								<li class="active">
									<a href="#panel-1" data-toggle="tab">填什么？</a>
								</li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="panel-1">
									<div class="panel panel-info">
										<div class="panel-heading">
											<h3 class="panel-title">
												<b>填什么？</b>
											</h3>
										</div>
										<div class="panel-body">
											<font color="red"><b>七个</b></font>源品种（<b>电力、煤炭、天然气、液化石油气、汽油、柴油、外购热力</b>）的消费量和消费金额（用了多少量，花了多少钱？）<br>
											<ol>
												<li><font color="red"><b>注意</b></font>：能源合计<font color="red"><b>不用填</b></font>（系统点击计算生成）</li>
												<li>外购热力（供暖费、热水等）<font color="red"><b>只填</b></font>金额</li>
											</ol>
										</div>
									</div>
								</div>
								<div class="tab-pane " id="panel-2">
									<div class="panel panel-success">
										<div class="panel-heading" >
											<h3 class="panel-title">
												<b>怎么填</b>
											</h3>
										</div>
										<div class="panel-body">
											
											<blockquote>
												<p>
													首先，明确基本原则（“法人”原则）
												</p> 
											</blockquote>
									
											<ol>
												<li><b>“法人”填报时应包含分公司、办事处等分支机构（产业活动单位）</b></li>
												<img class="img-rounded" width="100%"  src="image/611-7-fr.jpg" />
												<li><b>“法人”填报时不应包含其他法人（集团其他子公司等）</b></li>
												<img class="img-rounded" width="100%"  src="image/611-7-fr-no.jpg" />
											</ol>
											<blockquote>
												<p>
													其次，明确消费何种能源，分别填报
												</p> 
											</blockquote>
											
											<ol>
												<li><b>电力（天然气）怎么填？</b></li>
												
												①有计量仪表，按照抄表数填报</br></br>
												<img class="img-rounded" width="100%"  src="image/611-7-rqb.jpg" />
												</br></br>
												② 有消费单据（用电客户电费缴费通知单），<b>看结算电量小计</b>（消费量）和<b>计量点电费</b>（金额），按照所有单据<font color="red"><b>求和填报</b></font></br></br>
												<img class="img-rounded" width="100%"  src="image/611-7-jftzd.jpg" />
												</br></br>
												③ IC卡充值消费，可以按购入量填报
												</br></br>
												④ 只有消费量或只有金额，可以参考单价推算
												</br></br>
												<li><b>煤炭怎么填？</b></li>
												按照称重或购买量填报</br></br>
												<li><b>汽油、柴油怎么填？</b></li>
												① 确定有多少辆单位经营使用的“公车”</br></br>
												② IC卡加油网上打印对账单</br></br>
												<img class="img-rounded" width="100%"  src="image/611-7-ICdzd.jpg" />
												</br></br>
												③ 按照财务账中的金额，参考单价推算
												<li><b>外购热力（大部分是暖气费）怎么填？</b></li>
												</br></br>
												①只填金额（花了多少钱），不填消费量！
												</br></br>
												②包含供暖费、热水费、热蒸汽费等
												</br></br>
												③自采暖（自己烧锅炉），消费什么品种（电、天然气）报相应品种，不报热力
												</br></br>
												④不能包含往年补缴的、下年预交的、给职工报销的费用
												</br></br>
												<li><b>液化石油气怎么填？</b></li>
												</br></br>
												①北京地区通常为罐装</br></br>
												<img class="img-rounded" width="300px"  src="image/611-7-mqg-1.jpg" />
												</br></br>
												<img class="img-rounded" width="300px"  src="image/611-7-mqg-2.jpg" />
												</br></br>
												<img class="img-rounded" width="300px"  src="image/611-7-mqg-3.jpg" />
												</br></br>
												②管道煤气（京外）填报须换算成千克  <br>1立方米=2.033千克 <br>最后，各品种参考单价区间

											</ol>							
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		
	</div>
</body>
</html>