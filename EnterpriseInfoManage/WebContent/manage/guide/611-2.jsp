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
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;background-color:#5B00AE'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>本企业信息查看</a><a href='manage/consultation/consultation_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>填报咨询</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
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
					<ul class="breadcrumb" >
						<li>
							 从业人员情况611-2表填报手册
						</li>
					</ul>
				</div>
			</div>
		<!--</div>
		<div class="container">-->
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="tabbable" id="tabs-836087">
						<ul class="nav nav-tabs">
							<li class="active">
								 <a href="#panel-1" data-toggle="tab">从业人员期末人数</a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-1">
								<div class="panel panel-info">
									
									<div class="panel-body">
										指报告期末最后一日(12月31日）２４时在本单位工作，并取得工资或其他形式劳动报酬的人员数，是在岗职工、劳务派遣人员及其他从业人员之和。该指标为时点指标，<b>不包括最后一日当天及以前已经与单位解除劳动合同关系的人员</b>。（参考资料：花名册、考勤表、工资单等）
									</div>
								</div>
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>从业人员期末人数包括</b>
										</h3>
									</div>
									<div class="panel-body">
										<ol>
											<li>
												应订立劳动合同而未订立劳动合同的人员；
											</li>
											<li>
												处于试用期的人员； 
											</li>
											<li>
												非全日制人员；
											</li>
											<li>
												招用的临时人员；
											</li>
											<li>
												外派工作，但工资或其他形式劳动报酬仍由本单位发放的人员；
											</li>
											<li>
												由于学习、病伤、产假等原因暂未工作仍由单位支付工资的人员；
											</li>
											<li>
												劳务派遣人员；
											</li>
											<li>
												利用课余时间打工的在校学生；
											</li>
											<li>
												聘用的外籍和港澳台方人员；
											</li>
											<li>
												退休返聘人员;
											</li>
											<li>
												兼职人员等。
											</li>
										</ol>								
									</div>
								</div>
								<div class="panel panel-danger">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>从业人员期末人数不包括</b>
										</h3>
									</div>
									<div class="panel-body">
										<ol>
											<li>
												离开本单位仍保留劳动关系，并定期领取生活费的人员；
											</li>
											<li>
												在本单位实习的各类在校学生；
											</li>
											<li>
												本单位因劳务外包而使用的人员；
											</li>
											<li>
												本单位正式离退休人员，但不包括正式离退休后又被单位返聘的离退休人员；
											</li>
											<li>
												不在岗职工；
											</li>
											<li>
												参军人员。
											</li>
											
										</ol>
									</div>
								</div>
								<div class="panel panel-success">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>举例</b>
										</h3>
									</div>
									<div class="panel-body">
										某公司12月31日在本单位工作并领取工资的人员80人。其中：2人为31日合同到期不再续签，离职手续未办理。<br>
										<b>从业人员期末人数=80-2=78（人）</b>

									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-2">
								<div class="panel panel-info">
									
									<div class="panel-body">
										接受的最高一级教育，不包括肄业、结业、在读或辍学人员。
									</div>
								</div>
								<div class="panel panel-danger">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>不包括下列人员</b>
										</h3>
									</div>
									<div class="panel-body">
										<ol>
											<li>
												肄业；
											</li>
											<li>
												结业；
											</li>
											<li>
												在读；
											</li>
											<li>
												辍学；
											</li>
											
										</ol>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-3">
								<div class="panel panel-info">
									
									<div class="panel-body">
										在本单位从事生产性或服务性工作，并持有国家职业资格证书的人员。国家职业资格证书包括一级、二级、三级、四级、五级，同一个人持有两个及以上国家职业资格证书的，按最高等级证书认定。
									</div>
								</div>
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>包括下列人员</b>
										</h3>
									</div>
									<div class="panel-body">
										<ol>
											<li>
												在管理岗位和专业技术岗位之外从事生产或服务性工作，<b>并持有国家职业资格证书的</b>，统计为技能人员。
											</li>
											
										</ol>
									</div>
								</div>
								<div class="panel panel-danger">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>不包括下列人员</b>
										</h3>
									</div>
									<div class="panel-body">
										<ol>
											<li>
												在管理岗位和专业技术岗位工作的，无论是否持有国家职业资格证书，均不统计为技能人员。
											</li>
											<li>
												在管理岗位和专业技术岗位之外从事生产或服务性工作，<b>但没有国家职业资格证书的，不予统计</b>。
											</li>											
										</ol>
									</div>
								</div>
								<div class="panel panel-success">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>国家职业资格证书样式</b>
										</h3>
									</div>
									<div class="panel-body">
										<img class="img-rounded" width="80%" src="image/1.jpg" />
										<img class="img-rounded" width="80%" src="image/2.jpg" />
										<img class="img-rounded" width="80%" src="image/3.jpg" />
									</div>
								</div>
							</div>
							
							<div class="tab-pane" id="panel-4">
								<div class="panel panel-info">
									
									<div class="panel-body">
										1.工作地在外省市人员（BJ11）(BJ08)<br>
											<ul><li>指从业人员中工作地不在北京的人员。地域指京外，包括港、澳、台及境外。<b>人员不包含港、澳、台、外籍人员</b>。</li></ul>
										2.户口在外省市人员 （BJ07)<br>
											<ul><li>指从业人员中没有北京户口的人员，<b>不包含港、澳、台、外籍人员</b>.</li></ul>

									</div>
								</div>
								<div class="panel panel-danger">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>不包括下列人员</b>
										</h3>
									</div>
									<div class="panel-body">
										<ol>
											<li>
												<b>不包含港、澳、台、外籍人员</b>
											</li>									
										</ol>
									</div>
								</div>
								<div class="panel panel-success">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>举例</b>
										</h3>
									</div>
									<div class="panel-body">
										某公司12月31日在本单位工作并领取工资的人员10人，其中北京户籍6人，湖南户籍3人，香港籍1人。
										其中：4人在香港工作，其中1人为香港籍，2人为湖南户籍，1人为北京户籍，则：<br>
										<ul>
											<li>工作地在外省市人员（BJ11）=4-1=3（人）</li>
											<li>户口在外省市人员（BJ07)=3（人）      </li>        
											<li>工作地在外省市人员（BJ08）=2（人）</li>
										</ul>
									</div>
								</div>
								<div class="panel panel-warning">
									<div class="panel-heading">
										<h3 class="panel-title">
											<b>逻辑关系</b>
										</h3>
									</div>
									<div class="panel-body">
										<ul>
											<li>若从业人员期末人数（01）>0,则03、04、05中应至少有一项>0</li>
											<li>若从业人员期末人数（01）>5，则女性（02）应>0</li>
											<li>制造业、建筑业企业若从业人员期末人数（01）>10,则07-11项中应至少有一项>0</li>
										</ul>
										<b>以上条件如不满足，应注明原因。</b></br>
										<b>BJ11≤01   BJ07≤01   BJ08≤BJ07≤01   BJ08≤BJ11</b>

								
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-5">
								<div class="panel panel-success">									
									<div class="panel-body">
										<ol>
											<li>工资发放单位的详细名称、社会信用代码（正常营业的单位，一套人马两块牌子）</li>
											<li>停业（歇业），无留守人员</li>
											<li>筹建中，无从业人员</li>
											<li>关闭（破产）</li>
											<li>已注销 </li>
										</ol>
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