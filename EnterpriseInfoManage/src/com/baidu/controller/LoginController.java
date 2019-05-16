package com.baidu.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.bean.User;
import com.baidu.service.UserService;

@Controller
@RequestMapping("loginController")
public class LoginController {
	@Autowired
	private UserService service;
	
	@RequestMapping("loginValidate")
	@ResponseBody
	public void loginValidate(String userName,String userpwd,HttpServletResponse response,HttpServletRequest request)throws Exception{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if(userName==null||userName.equals("")||userpwd==null||userpwd.equals("")){
			response.getWriter().write("<script>alert('用户名或密码为空');location.href='/EnterpriseInfoManage/login/Login.jsp'</script>");
		}
//		System.out.println(this.service.loginValidate(userName,userpwd)+"user");
		User user=this.service.loginValidate(userName,userpwd);
		if(user!=null){
			/**
			 * 用户登录成功后 将账号密码存起来  后面直接从cookies中拿
			 */
			String userState= user.getUser_state();
	
			Cookie cookie1 = new Cookie("userName",userName);
			Cookie cookie2 = new Cookie("userState",userState);
			cookie1.setMaxAge(24*60*60*60);
			cookie2.setMaxAge(24*60*60*60);
			cookie1.setPath("/");
			cookie2.setPath("/");
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		
			
			response.getWriter().write("<script>location.href='/EnterpriseInfoManage/manage/main.jsp?username="+userName+"&userState="+userState+"'</script>");
		}
		response.getWriter().write("<script>alert"
				+ "'登录失败');location.href='/EnterpriseInfoManage/login/Login.jsp'</script>");
	}
	
}
