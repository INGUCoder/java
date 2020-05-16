package com.example.demo.service.aliPay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AlipayService {
    /**
     * 支付宝支付调用接口
     * @param response
     * @param request
     * @throws IOException
     */
    void  aliPay(HttpServletResponse response, HttpServletRequest request,String orderId,String orderName,double price) throws IOException;
}


