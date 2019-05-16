package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.bean.EnterpriseInfo;
import com.baidu.service.EnterpriseInfoService;

@Controller
@RequestMapping("enterpriseInfoController")
public class EnterpriseInfoController {
	@Autowired
	private EnterpriseInfoService service;
	
	@RequestMapping("getEnterprise")
	@ResponseBody
	public List<EnterpriseInfo> getEnterprise(Integer pageNum,Integer pageSize,String enterpriseName){
		return this.service.getEnterprise(pageNum,pageSize,enterpriseName);
	}
	
	@RequestMapping("getAllEnterprise")
	@ResponseBody
	public List<EnterpriseInfo> getAllEnterprise(){
		return this.service.getAllEnterprise();
	}
	
	@RequestMapping("getLen")
	@ResponseBody
	public Integer getLen(String enterpriseName){
		return this.service.getLen(enterpriseName);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public Integer delEnterprise(Integer enterpriseId){
		return this.service.delEnterprise(enterpriseId);
	}
	
	@RequestMapping("selectById")
	@ResponseBody
	public EnterpriseInfo selectById(Integer enterpriseId){
		return this.service.selectById(enterpriseId);
	}
	
	
	@RequestMapping("addEnterprise")
	@ResponseBody
	public Integer addEnterprise(EnterpriseInfo enterpriseInfo){
		System.out.println(enterpriseInfo);
		return this.service.addEnterprise(enterpriseInfo);
	}
	
	@RequestMapping("updEnterprise")
	@ResponseBody
	public Integer updEnterprise(EnterpriseInfo enterpriseInfo){
		System.out.println(enterpriseInfo);
		return this.service.updEnterprise(enterpriseInfo);
	}
	
}
