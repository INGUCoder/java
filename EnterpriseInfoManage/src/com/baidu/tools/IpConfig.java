package com.baidu.tools;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class IpConfig {
	  public static String getMACAddress(InetAddress ia)throws Exception{  
	        //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。  
	        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();  
	          
	        //下面代码是把mac地址拼装成String  
	        StringBuffer sb = new StringBuffer();  
	          
	        for(int i=0;i<mac.length;i++){  
	            if(i!=0){  
	                sb.append("-");  
	            }  
	            //mac[i] & 0xFF 是为了把byte转化为正整数  
	            String s = Integer.toHexString(mac[i] & 0xFF);  
//	            System.out.println("--------------");
//	            System.err.println(s);
//	            
	            sb.append(s.length()==1?0+s:s);  
	        }  
	          
	        //把字符串所有小写字母改为大写成为正规的mac地址并返回  
	        return sb.toString().toUpperCase();  
	    }  
	  
	  /**
	     * 得到访问者的IP地址
	     * @return ip
	     * @throws Exception
	     */
	    public static String getIp(HttpServletRequest request) throws Exception{
	        String ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        System.out.println(ip+0);
	        if(ip!=null){
	            if(!ip.isEmpty()&&!"unKnown".equalsIgnoreCase(ip)){
	                int index = ip.indexOf(",");
	                if (index != -1){
	                    return ip.substring(0,index);
	                }else{
	                    return ip;
	                }
	            }
	        }
	        System.out.println(ip+1);
	        ip=request.getRemoteAddr();
	        System.out.println(ip+3);
	        ip = ServletActionContext.getRequest().getHeader("X-Real-IP");
	        System.out.println(ip+2);
	        if(ip!=null){
	            if (!ip.isEmpty()&&!"unKnown".equalsIgnoreCase(ip)){
	                return ip;
	            }
	        }
	        return  request.getRemoteAddr();
	    }
	 
	
	    
	    public static String getIPAddress(HttpServletRequest request){
//	    	System.out.println(request+"request");
	    	
	    	//request对象获取
	    	 Map<String,Object> map = new HashMap<String,Object>(); 
	    	 Enumeration paramNames = request.getParameterNames(); 
	    	 while (paramNames.hasMoreElements()) { 
	    		 String paramName = (String) paramNames.nextElement();
	    		 String[] paramValues = request.getParameterValues(paramName); 
	    		 if (paramValues.length >0) { 
	    			 String paramValue = paramValues[0]; 
	    			 if (paramValue.length() != 0) { 
	    				 map.put(paramName, paramValue); 
	    			 } 
	    		 } 
	    	 } 
//	    	 Set<Map.Entry<String, Object>> set = map.entrySet(); 
//	    	 for (Map.Entry entry : set) {  
//	                 
//	            }
	    	 
	    	
	    	  String ip = request.getHeader("x-forwarded-for");
	    	  if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
	    		  ip= request.getHeader("Proxy-Client-IP");
			  }
	    	  if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
	    		  ip= request.getHeader("WL-Proxy-Client-IP");
			  }
	    	  if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
	    		  ip= request.getHeader("HTTP_CLIENT_IP");
			  }
	    	  if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
	    		  ip= request.getHeader("HTTP_X_FORWARDED_FOR");
			  }
	    	  if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
	    		  ip=request.getRemoteAddr();
			  }
	    	 return ip;
	    }
	    
	   
	    /**
	     * 通过访问的Ip地址得到mac地址
	     * @param ip
	     * @return mac
	     */
	    public static String getMacByIp(String ip){
	        String macAddress = "";
	        try {
	            java.lang.Process process = Runtime.getRuntime().exec("nbtstat -A "+ip);
	            InputStreamReader ir = new InputStreamReader(process.getInputStream());
	            LineNumberReader input = new LineNumberReader(ir);
	            String str = "";
	            while ((str=input.readLine())!=null){
	                str = str.toUpperCase();
	                if(str.indexOf("MAC ADDRESS")>1){
	                    int start = str.indexOf("=");
	                    macAddress = str.substring(start+1,str.length()).trim();
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return  macAddress;
	    }
	    
	  

}
