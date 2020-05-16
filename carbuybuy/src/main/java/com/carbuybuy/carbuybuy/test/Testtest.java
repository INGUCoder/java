package com.carbuybuy.carbuybuy.test;

import com.carbuybuy.carbuybuy.sms.SmsUtils;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestParam;

public class Testtest {

    @Test
    public void test(){
        System.out.println("q2222");
    }
    @Test
    public void Sms(@RequestParam("phone") String phone) {
        String smsCode = SmsUtils.sendSms("15994962417");
        //存储验证码 设置过期时间
        System.out.println(smsCode);

    }


}
