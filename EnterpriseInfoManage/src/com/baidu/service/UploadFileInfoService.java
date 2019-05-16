package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.bean.UploadFileInfo;
import com.baidu.mapper.UploadFileInfoMapper;

@Service
public class UploadFileInfoService {

	@Autowired
	UploadFileInfoMapper mapper;
	
	public void insertFileInfo(String filename,String url) {
		this.mapper.insertFileInfo(filename, url);
		
	}
	
	public List<UploadFileInfo> selectFile(){
		
		return this.mapper.selectFile();
		
	}
	
	
	
	
	
}
