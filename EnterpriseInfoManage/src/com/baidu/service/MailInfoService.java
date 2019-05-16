package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.bean.EnterpriseInfo;
import com.baidu.bean.MailInfo;
import com.baidu.mapper.EnterpriseInfoMapper;
import com.baidu.mapper.MailInfoMapper;
@Service
public class MailInfoService {
	@Autowired
	private MailInfoMapper mapper;
	
	public List<MailInfo> getMail(Integer pageNum,Integer pageSize){
		return this.mapper.getMail(pageNum,pageSize);
	}
	
	public List<MailInfo> mailStatistics(){
		return this.mapper.mailStatistics();
	}
	
	public Integer getLen(){
		return this.mapper.getLen();
	}
	
	public Integer delMail(Integer id){
		return this.mapper.deleteByPrimaryKey(id);
	}
	
	public MailInfo selectById(Integer enterpriseId){
		return this.mapper.selectByPrimaryKey(enterpriseId);
	}
	
	public Integer addMail(MailInfo mailInfo){
		return this.mapper.insert(mailInfo);
	}
	
	public Integer updMail(MailInfo mailInfo){
		return this.mapper.updateByPrimaryKey(mailInfo);
	}
}
