package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.bean.EnterpriseInfo;
import com.baidu.bean.MailInfo;
import com.baidu.service.MailInfoService;
@Controller
@RequestMapping("mailInfoController")
public class MailInfoController {
	@Autowired
	private MailInfoService service;
	
	@RequestMapping("getMail")
	@ResponseBody
	public List<MailInfo> getMail(Integer pageNum,Integer pageSize){
		return this.service.getMail(pageNum,pageSize);
	}
	
	@RequestMapping("mailStatistics")
	@ResponseBody
	public List<MailInfo> mailStatistics(){
		return this.service.mailStatistics();
	}
	
	@RequestMapping("getLen")
	@ResponseBody
	public Integer getLen(){
		return this.service.getLen();
	}
	
	@RequestMapping("del")
	@ResponseBody
	public Integer delMail(Integer mailId){
		return this.service.delMail(mailId);
	}
	
	@RequestMapping("selectById")
	@ResponseBody
	public MailInfo selectById(Integer mailId){
		return this.service.selectById(mailId);
	}
	
	
	@RequestMapping("addMail")
	@ResponseBody
	public Integer addMail(MailInfo mailInfo){
		return this.service.addMail(mailInfo);
	}
	
	@RequestMapping("updMail")
	@ResponseBody
	public Integer updMail(MailInfo mailInfo){
		System.out.println(this.service.updMail(mailInfo));
		return this.service.updMail(mailInfo);
	}
}
