package com.example.demo.Controller;

import com.example.demo.domain.*;
import com.example.demo.repository.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.nio.channels.FileChannel;

@Controller
@RequestMapping("/user")
public class UserController {
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
            Tongzhi tongzhi1 = tongzhiMapper.selectAllById(1);
            Tongzhi tongzhi2= tongzhiMapper.selectAllById(2);
            Tongzhi tongzhi3 = tongzhiMapper.selectAllById(3);
            Tongzhi tongzhi4 = tongzhiMapper.selectAllById(4);
            Tongzhi tongzhi5 = tongzhiMapper.selectAllById(5);

            map.addAttribute("tongzhiinfo1",tongzhi1.getInfo());
            map.addAttribute("tongzhiurl1",tongzhi1.getUrl());
            map.addAttribute("tongzhiinfo2",tongzhi2.getInfo());
            map.addAttribute("tongzhiurl2",tongzhi2.getUrl());
            map.addAttribute("tongzhiinfo3",tongzhi3.getInfo());
            map.addAttribute("tongzhiurl3",tongzhi3.getUrl());
            map.addAttribute("tongzhiinfo4",tongzhi4.getInfo());
            map.addAttribute("tongzhiurl4",tongzhi4.getUrl());
            map.addAttribute("tongzhiinfo5",tongzhi5.getInfo());
            map.addAttribute("tongzhiurl5",tongzhi5.getUrl());

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



            return "usersindex";




    }




}
