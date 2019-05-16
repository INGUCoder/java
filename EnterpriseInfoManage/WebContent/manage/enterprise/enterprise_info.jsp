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
			fenYe();
		$("#select").click(function(){
			fenYe();
		})
		if(userState=="办公室"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;background-color:#5B00AE'>企业信息管理</a><a href='manage/user/user_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>系统角色管理</a><a href='manage/releasepdf/releasepdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>新公告发布</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}else if(userState=="普查人员"){
			$(".head_model").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='manage/main.jsp?username="+username+"&userState="+userState+"' style='color: white;'>首页</a><a href='manage/enterprise/enterprise_info.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;background-color:#5B00AE'>企业信息管理</a><a href='manage/mail/mailInfoSel.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>企业邮寄</a><a href='manage/releasepdf/viewPdf.jsp?username="+username+"&userState="+userState+"' class='model' style='color: white;'>查看公告</a>");
		}
		$("#exit").click(function(){
			location.href="http://"+test+"/EnterpriseInfoManage/login/Login.jsp";
		})
		$("#username").click(function(){
			//location.href="http://"+test+"/LiCreaOfficialWebsite/usermanager/selectuser.jsp?username="+username;
		})
		 $("#btn1").click(function firstPage(){    // 首页
	        	fanye(1);
	        });
	        $("#btn2").click(function frontPage(){    // 上一页
	        	fanye(2);
	        });
	        $("#btn3").click(function nextPage(){    // 下一页
	        	fanye(3);
	        });
	        $("#btn4").click(function lastPage(){    // 尾页
	        	fanye(4);
	        });
	        $("#btn5").click(function changePage(){    // 转页
	        	fanye(0);
	        });
	})
	
	function fanye(y){
		if(y==1){
			curPage=1;
		}else if(y==2){
			curPage-=1;
			if(curPage<=0){
				alert("已经是第一页了");
				curPage+=1;
				return false;
			}
		}else if(y==3){
			curPage+=1;
			if(curPage>=page+1){
				alert("已经是最后一页了");
				curPage-=1;
				return false;
			}
		}else if(y==4){
			curPage=page;
		}else if(y==0){
			 curPage=document.getElementById("changePage").value * 1;
	            if (!/^[1-9]\d*$/.test(curPage)) {
	                alert("请输入正整数");
	                return ;
	            }
	            if (curPage > page) {
	                alert("超出数据页面");
	                return ;
	            }	
		}
		 loding(curPage-1);
         document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页  ";    // 显示当前多少页
	}
	

	function loding(pageNum){
		$.ajax({
			type:"post",
			url:"http://"+test+"/EnterpriseInfoManage/enterpriseInfoController/getEnterprise?pageNum="+pageNum+"&pageSize="+pageSize,
			dataType:"json",
			data:{
				enterpriseName:$("#enterpriseName").val()
			},
			success:function(data){
				var html ="";
				$.each(data,function(index,item){
					html +="<tr><td>"+item.enterpriseZoningDivision+"</td><td>"+item.enterpriseUnifiedSocialCreditCode+"</td><td>"+item.enterpriseOrganizationalCode+"</td><td>"+item.enterpriseDetailedName+"</td><td>"+item.enterpriseLegalRepresentative+"</td><td>"+item.enterpriseAddressStatus+"</td><td>"+item.enterpriseDetailedAddress+"</td><td>"+item.enterpriseMobilePhone+"</td><td>"+item.enterpriseBusinessActivities+"</td><td>"+item.enterpriseIndustryCode+"</td><td>"+item.enterpriseRegistrationTypes+"</td><td>"+item.enterpriseIsHaveBranchOffice+"</td><td>"+item.enterpriseArea+"</td><td>"+item._611+"</td><td>"+item._6111+"</td><td>"+item._6112+"</td><td>"+item._6113+"</td><td>"+item._61144+"</td><td>"+item._6115+"</td><td>"+item._6116+"</td><td>"+item._61177+"</td><td>"+item.enterpriseEnergyConsumption+"</td><td>"+item.enterpriseInvestmentFixedAssets+"</td><td>"+item.enterpriseRegistrationType+"</td><td>"+item.enterpriseOperationState+"</td><td>"+item.enterpriseRegistrationStatus+"</td><td>"+item.enterpriseSupplementaryItems+"</td><td><a href='manage/enterprise/updEnterprise.jsp?enterpriseId="+item.enterpriseId+"&username="+username+"&userState="+userState+"'><input type='button' value='修改'/></a><input type='button'  value='删除' onclick='delEnterprise("+item.enterpriseId+")'/></td></tr>";
				})
				if(html==""){
					html +="<tr><td style='font-size: 20px;font-weight: 600;color:gray' colspan='3'>未找到相关信息</td></tr>";
				}
				$(".tbody").html(html);
			}
		})
	}

	function fenYe(){
       	$.ajax({
       		async:false,
       		type:"post",
       		url:"http://"+test+"/EnterpriseInfoManage/enterpriseInfoController/getLen",
       		data:{
       			enterpriseName:$("#enterpriseName").val()	
       		},
       		success:function(data){
       			len=data;	
       		}
       	})
           page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
           curPage=1;    // 设置当前为第一页
           loding(curPage-1);
           document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页  ";    // 显示当前多少页
           document.getElementById("sjzl").innerHTML="数据总量 " + len + "";        // 显示数据量
	}
	function delEnterprise(enterpriseId){
	    if (confirm("你确定要删除此企业吗？")){ 
        }else{
        	alert("删除取消");
        	return false;
        }
		$.ajax({
			type:"post",
			url:"http://"+test+"/EnterpriseInfoManage/enterpriseInfoController/del?enterpriseId="+enterpriseId,
			dataType:"json",
			success:function(data){
				if(data>0){
					alert("删除成功");
					location.reload();	
				}else{
					alert("删除失败");
					location.reload();	
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
			<a href="manage/enterprise/addEnterprise.jsp?username=<%=request.getParameter("username")%>&userState=<%=request.getParameter("userState")%>"><div class="model_operation model_list_add">添加</div></a><hr/>
		</div>
	</div>
	<div class="page_right">
		<div class="page_right_head">
			<div class="head_text">
			</div>
		</div>
		<br/>
		<div class="model_select" align="center" style="color: gray">
			企业名：<input id="enterpriseName"/> &nbsp;&nbsp;&nbsp;<input id="select" type="button" value="查询" /><a href="javascript:history.back(-1)"><input id="return" type="button" value="返回上一页" /></a>
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
						<a id="btn0"></a>
						<a id="sjzl"></a> 
						<a id="btn1">首页</a>&nbsp;&nbsp;&nbsp;
						<a id="btn2">上一页</a>&nbsp;&nbsp;&nbsp;
						<a id="btn3">下一页</a>&nbsp;&nbsp;&nbsp;
						<a id="btn4">尾页</a> &nbsp;&nbsp;&nbsp;
						<a>转到 </a>
						<input id="changePage" type="text" size="1" maxlength="4"/>
						<a>页 </a>&nbsp;&nbsp;&nbsp;
						<a  id="btn5">跳转</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>