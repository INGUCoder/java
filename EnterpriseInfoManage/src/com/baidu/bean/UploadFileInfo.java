package com.baidu.bean;
/**
 * 
 * 
 *
 */
public class UploadFileInfo {
	private Integer id;
	private String filename;
	private String url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "UploadFileInfo [id=" + id + ", filename=" + filename + ", url=" + url + "]";
	}
	public UploadFileInfo(Integer id, String filename, String url) {
	
		this.id = id;
		this.filename = filename;
		this.url = url;
	}

	
	
	public UploadFileInfo() {
	
		
	}
	
	
	
	

}
