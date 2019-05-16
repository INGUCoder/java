package com.baidu.controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baidu.bean.UploadFileInfo;
import com.baidu.service.UploadFileInfoService;
/**
 * 
 * 文件上传工具类  公告
 *
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
	
	/**
	 * 私有静态方法
	 */
	private static Map<String,Cookie> ReadCookies(HttpServletRequest request){
		Map<String,Cookie> cookieMap =new HashMap<String,Cookie>();

	       Cookie[] cookies = request.getCookies();

	    if(null!=cookies){

	           for(Cookie cookie : cookies){

	               cookieMap.put(cookie.getName(),cookie);

	           }

	       }

	       return cookieMap;

	   }
	
	@Autowired
	UploadFileInfoService uploadFileInfoService;
  
	@RequestMapping("/upload")
	public String upload(@RequestParam("file_01")CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response)throws IOException{
		
		/**
		 *  检测上传文件所用时间  开始时间
		 */
		
		long startTime = System.currentTimeMillis();
		
		try {
			/**
			 *获取输出流    保存文件所在的路径	
			 */
			OutputStream os =new FileOutputStream("C:\\Users\\mz\\Desktop\\sheji\\EnterpriseInfoManage\\WebContent\\image\\"+file.getOriginalFilename());
			/**
			 * 获取输入流 CommonsMultipartFile中可以直接得到文件的流
			 */
			InputStream is = file.getInputStream();
			/**
			 * 设置变量    判断文件流是否读取写出完成    为-1 代表
			 */
			int temp;
			/**
			 * 一个一个字节读取并输入   temp等于-1表示文件写入完毕
			 */
			while((temp=is.read())!=(-1)) {
				os.write(temp);
			}
			/**
			 * 关闭资源
			 */
			
			/**
			 * 表示数据写完了   
			 */
			os.flush();
			os.close();
			is.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		/**
		 * 文件上传完成结束时间
		 */
		long endtime = System.currentTimeMillis();
		
		/**
		 * 将上传的文件名称  目录写进数据库
		 */
		System.out.println(file.getOriginalFilename());
		
		String name = request.getParameter("filename");
		String url = "C:\\Users\\mz\\Desktop\\sheji\\EnterpriseInfoManage\\WebContent\\image\\"+file.getOriginalFilename();
		uploadFileInfoService.insertFileInfo(name, url);
		
		
		
		/**
		 * 算出所用时间
		 */
		System.out.println("传输文件所用时间:"+String.valueOf(endtime-startTime));
		/**
		 * 添加变量  存储cookie数据
		 */
		String userName = null;
		String userState = null;
		/**
		 * 调用ReadCookies 方法取值
		 */
		Map<String,Cookie> cookieMap =FileUploadController.ReadCookies(request);
		 if(cookieMap.containsKey("userName")&&cookieMap.containsKey("userState")){  //cookieName 为cookie名称
			 	
	          Cookie cookie1 = (Cookie)cookieMap.get("userName");
	          Cookie cookie2 = (Cookie)cookieMap.get("userState");
	          userName = cookie1.getValue();
	          userState = cookie2.getValue();
	          System.out.println("取到的值");
	          System.out.println("cookie="+cookie1.getValue());
	          System.out.println("cookie="+cookie2.getValue());
	          System.out.println(userName+userState);
	          
	    }	
		 System.out.println("---Test--A----");
		 
		 List<UploadFileInfo> list = this.uploadFileInfoService.selectFile();
		 
		 for(UploadFileInfo a:list) {
			 System.out.println(a);
		 }
		
		 request.setAttribute("userName", userName);
		 request.setAttribute("list", list);
	
	
		 return "viewPdf";
		
	//	response.getWriter().write("<script>location.href='/EnterpriseInfoManage/manage/releasepdf/viewPdf.jsp?username="+userName+"&userState="+userState+"'</script>");
		
	}
	
	
	
	@RequestMapping("/gongGao")
	public String gongGao(HttpServletRequest request) {
		
		
		/**
		 * 添加变量  存储cookie数据
		 */
		String userName = null;
		String userState = null;
		/**
		 * 调用ReadCookies 方法取值
		 */
		Map<String,Cookie> cookieMap =FileUploadController.ReadCookies(request);
		 if(cookieMap.containsKey("userName")&&cookieMap.containsKey("userState")){  //cookieName 为cookie名称
			 	
	          Cookie cookie1 = (Cookie)cookieMap.get("userName");
	          Cookie cookie2 = (Cookie)cookieMap.get("userState");
	          userName = cookie1.getValue();
	          userState = cookie2.getValue();
	          System.out.println("取到的值");
	          System.out.println("cookie="+cookie1.getValue());
	          System.out.println("cookie="+cookie2.getValue());
	          System.out.println(userName+userState);
	          
	    }	
		 System.out.println("---Test--A----");
		 
		 List<UploadFileInfo> list = this.uploadFileInfoService.selectFile();
		 
		 for(UploadFileInfo a:list) {
			 System.out.println(a);
		 }
		 /**
		  * 测试
		  */
		 request.setAttribute("userName", userName);
		 request.setAttribute("list", list);
		 System.out.println("----Test---B---");
	
		 return "viewPdf";
		
		
		
	}
	

}

