package com.baidu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.bean.ConsultationInfo;
import com.baidu.bean.EnterpriseInfo;
import com.baidu.mapper.ConsultationInfoMapper;
import com.baidu.service.ConsultationInfoService;
@Controller
@RequestMapping("consultationInfoController")
public class ConsultationInfoController {
	@Autowired
	private ConsultationInfoService service;
	@RequestMapping("getConsultation")
	@ResponseBody
    public List<ConsultationInfo> getConsultation(Integer pageNum,Integer pageSize){
    	return this.service.getConsultation(pageNum, pageSize);
    }
	
	@RequestMapping("getLen")
	@ResponseBody
	public Integer getLen(){
		return this.service.getLen();
	}
}