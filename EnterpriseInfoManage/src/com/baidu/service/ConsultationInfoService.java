package com.baidu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.bean.ConsultationInfo;
import com.baidu.bean.EnterpriseInfo;
import com.baidu.mapper.ConsultationInfoMapper;
@Service
public class ConsultationInfoService {
	@Autowired
	private ConsultationInfoMapper mapper;
	
    public List<ConsultationInfo> getConsultation(Integer pageNum,Integer pageSize){
    	return this.mapper.getConsultation(pageNum, pageSize);
    }
    
	public Integer getLen(){
		return this.mapper.getLen();
	}
}