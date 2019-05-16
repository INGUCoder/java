package com.baidu.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.bean.UploadFileInfo;
import com.baidu.service.UploadFileInfoService;

public class UploadFileInfoUtil {
	
	
	@Autowired
	UploadFileInfoService fileInfoService;
	
	
	public List<UploadFileInfo> selectFile(){
		
		return this.fileInfoService.selectFile();
		
		
	}
	
	

}
