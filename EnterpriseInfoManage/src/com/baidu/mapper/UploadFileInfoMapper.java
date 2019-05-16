package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.bean.UploadFileInfo;

public interface UploadFileInfoMapper {
	
	
	void insertFileInfo(@Param("filename") String filename,@Param("url") String url);
	List<UploadFileInfo> selectFile();

}
