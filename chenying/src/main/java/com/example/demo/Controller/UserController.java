package com.example.demo.Controller;

import com.example.demo.domain.*;
import com.example.demo.repository.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.nio.channels.FileChannel;
import java.util.List;
@Service
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    DangshiMapper dangshiMapper;

    @Autowired
    TongzhiMapper tongzhiMapper;

    @Autowired
    GaocengMapper gaocengMapper;

    @Autowired
    ShidaiMapper shidaiMapper;

    @Autowired
    JibingMapper jibingMapper;
    @Autowired
    ZhibuMapper  zhibuMapper;
        @Autowired
        ZhishuMapper zhishuMapper;
        @Autowired
        JavaMailSender mailSender;
    //显示新闻信息
    @RequestMapping("/index")

    public String login(HttpServletRequest request, ModelMap map){
            //显示党史
            Dangshi dangshi1=dangshiMapper.selectAllById(1);
            Dangshi dangshi2=dangshiMapper.selectAllById(2);
            Dangshi dangshi3=dangshiMapper.selectAllById(3);
            Dangshi dangshi4=dangshiMapper.selectAllById(4);
            Dangshi dangshi5=dangshiMapper.selectAllById(5);
            map.addAttribute("info1",dangshi1.getInfo());
            map.addAttribute("url1",dangshi1.getUrl());
            map.addAttribute("info2",dangshi2.getInfo());
            map.addAttribute("url2",dangshi2.getUrl());
            map.addAttribute("info3",dangshi3.getInfo());
            map.addAttribute("url3",dangshi3.getUrl());
            map.addAttribute("info4",dangshi4.getInfo());
            map.addAttribute("url4",dangshi4.getUrl());
            map.addAttribute("info5",dangshi5.getInfo());
            map.addAttribute("url5",dangshi5.getUrl());
            //显示通知公告
            List<Tongzhi> tongzhiList = tongzhiMapper.selectAll();

            //显示高层动态
            Gaoceng gaoceng1 = gaocengMapper.selectAllById(1);
            Gaoceng gaoceng2 = gaocengMapper.selectAllById(2);
            Gaoceng gaoceng3 = gaocengMapper.selectAllById(3);
            Gaoceng gaoceng4 = gaocengMapper.selectAllById(4);
            Gaoceng gaoceng5 = gaocengMapper.selectAllById(5);

            map.addAttribute("gaocenginfo1",gaoceng1.getInfo());
            map.addAttribute("gaocengurl1",gaoceng1.getUrl());
            map.addAttribute("gaocenginfo2",gaoceng2.getInfo());
            map.addAttribute("gaocengurl2",gaoceng2.getUrl());
            map.addAttribute("gaocenginfo3",gaoceng3.getInfo());
            map.addAttribute("gaocengurl3",gaoceng3.getUrl());
            map.addAttribute("gaocenginfo4",gaoceng4.getInfo());
            map.addAttribute("gaocengurl4",gaoceng4.getUrl());
            map.addAttribute("gaocenginfo5",gaoceng5.getInfo());
            map.addAttribute("gaocengurl5",gaoceng5.getUrl());

            //显示时代先锋
            Shidai shidai1 = shidaiMapper.selectAllById(1);
            Shidai shidai2 = shidaiMapper.selectAllById(2);
            Shidai shidai3 = shidaiMapper.selectAllById(3);
            Shidai shidai4 = shidaiMapper.selectAllById(4);
            Shidai shidai5 = shidaiMapper.selectAllById(5);

            map.addAttribute("shidaiinfo1",shidai1.getInfo());
            map.addAttribute("shidaiurl1",shidai1.getUrl());
            map.addAttribute("shidaiinfo2",shidai2.getInfo());
            map.addAttribute("shidaiurl2",shidai2.getUrl());
            map.addAttribute("shidaiinfo3",shidai3.getInfo());
            map.addAttribute("shidaiurl3",shidai3.getUrl());
            map.addAttribute("shidaiinfo4",shidai4.getInfo());
            map.addAttribute("shidaiurl4",shidai4.getUrl());
            map.addAttribute("shidaiinfo5",shidai5.getInfo());
            map.addAttribute("shidaiurl5",shidai5.getUrl());

            //显示疾病控制
            Jibing jibing1 = jibingMapper.selectAllById(1);
            Jibing jibing2 = jibingMapper.selectAllById(2);
            Jibing jibing3 = jibingMapper.selectAllById(3);
            Jibing jibing4 = jibingMapper.selectAllById(4);
            Jibing jibing5 = jibingMapper.selectAllById(5);

            map.addAttribute("jingbinginfo1",jibing1.getInfo());
            map.addAttribute("jibingurl1",jibing1.getUrl());
            map.addAttribute("jingbinginfo2",jibing2.getInfo());
            map.addAttribute("jibingurl2",jibing2.getUrl());
            map.addAttribute("jingbinginfo3",jibing3.getInfo());
            map.addAttribute("jibingurl3",jibing3.getUrl());
            map.addAttribute("jingbinginfo4",jibing4.getInfo());
            map.addAttribute("jibingurl4",jibing4.getUrl());
            map.addAttribute("jingbinginfo5",jibing5.getInfo());
            map.addAttribute("jibingurl5",jibing5.getUrl());

            //显示支部信息
            Zhibu zhibu1 = zhibuMapper.selectAllById(1);
            Zhibu zhibu2 = zhibuMapper.selectAllById(2);
            Zhibu zhibu3 = zhibuMapper.selectAllById(3);
            Zhibu zhibu4 = zhibuMapper.selectAllById(4);
            Zhibu zhibu5 = zhibuMapper.selectAllById(5);

            map.addAttribute("zhibuinfo1",zhibu1.getInfo());
            map.addAttribute("zhibuurl1",zhibu1.getUrl());
            map.addAttribute("zhibuinfo2",zhibu2.getInfo());
            map.addAttribute("zhibuurl2",zhibu2.getUrl());
            map.addAttribute("zhibuinfo3",zhibu3.getInfo());
            map.addAttribute("zhibuurl3",zhibu3.getUrl());
            map.addAttribute("zhibuinfo4",zhibu4.getInfo());
            map.addAttribute("zhibuurl4",zhibu4.getUrl());
            map.addAttribute("zhibuinfo5",zhibu5.getInfo());
            map.addAttribute("zhibuurl5",zhibu5.getUrl());

            List<Zhishu> list = zhishuMapper.selectAll();
            map.addAttribute("tongzhi",tongzhiList);
            map.addAttribute("zhushu",list);
            return "usersindex";




    }
    @RequestMapping("/mail")
    public String mail(HttpServletRequest request){
            String number = request.getParameter("number");
            String zhuti = request.getParameter("zhuti");
            String neirong = request.getParameter("neirong");
            String mail = "chengying112@163.com";

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom("chengying112@163.com");
            //邮件接收人
            simpleMailMessage.setTo(mail);
            //邮件主题
            simpleMailMessage.setSubject("来自"+number+"的邮件:"+zhuti);
            //邮件内容
            simpleMailMessage.setText(neirong);
            mailSender.send(simpleMailMessage);
              return "emailSuccess";
    }
   @RequestMapping("/sendmail")
    public String sendmail(){
        return  "sendmail";
   }

//查看用户个人信息
    @RequestMapping("/userinfo")
    public String userinfo(Model model,HttpServletRequest request){
        String userinfo = request.getParameter("bianhao");
        System.out.println(userinfo);
        Users users = userMapper.userifo(userinfo);
        model.addAttribute("users",users);
        return "userinfo";
    }
    //修改党员信息
    @RequestMapping("/useralter")
    public String useralter(HttpServletRequest request){
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String minzu = request.getParameter("minzu");
        String jiguan = request.getParameter("jiguan");
        String phone = request.getParameter("phone");
        String idcard = request.getParameter("idcard");
        String birthday = request.getParameter("birthday");
        String work = request.getParameter("work");
        String education = request.getParameter("education");
        String address = request.getParameter("address");
        String rudangtime = request.getParameter("rudangtime");
        String people = request.getParameter("people");
        String zhibu = request.getParameter("zhibu");
        String status = request.getParameter("status");
        String zhibubianhao = request.getParameter("zhibubianhao");
        String bianhao = request.getParameter("bianhao");
        adminMapper.updateNumber(username,sex,minzu,jiguan,phone,idcard,birthday,work,education,address,rudangtime,people,zhibu,status,zhibubianhao,bianhao);
        return "membeAlter-Success";
    }


}
