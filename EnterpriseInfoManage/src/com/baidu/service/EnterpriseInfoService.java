package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.bean.EnterpriseInfo;
import com.baidu.mapper.EnterpriseInfoMapper;

@Service
public class EnterpriseInfoService {
	@Autowired
	private EnterpriseInfoMapper mapper;
	
	public List<EnterpriseInfo> getAllEnterprise(){
		return this.mapper.getAllEnterprise();
	}
	
	public List<EnterpriseInfo> getEnterprise(Integer pageNum,Integer pageSize,String enterpriseName){
		return this.mapper.getEnterprise(pageNum,pageSize,enterpriseName);
	}
	
	public Integer getLen(String enterpriseName){
		return this.mapper.getLen(enterpriseName);
	}
	
	public Integer delEnterprise(Integer id){
		return this.mapper.deleteByPrimaryKey(id);
	}
	
	public EnterpriseInfo selectById(Integer enterpriseId){
		return this.mapper.selectByPrimaryKey(enterpriseId);
	}
	
	public Integer addEnterprise(EnterpriseInfo enterpriseInfo){
		return this.mapper.insert(enterpriseInfo);
	}
	
	public Integer updEnterprise(EnterpriseInfo enterpriseInfo){
		return this.mapper.updateByPrimaryKey(enterpriseInfo);
	}
}
