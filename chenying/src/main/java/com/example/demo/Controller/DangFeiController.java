package com.example.demo.Controller;

import com.example.demo.domain.DangFei;
import com.example.demo.repository.mapper.DangFeiMapper;
import com.example.demo.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dangfei")
public class DangFeiController {
    @Autowired
    DangFeiMapper dangFeiMapper;

    //党费列表页面
    @RequestMapping("/dangfeiPage")
    public String dangfeiPage(Model model) {
        List<DangFei> dangFeiList = dangFeiMapper.selectAll();
        model.addAttribute("list", dangFeiList);
        model.addAttribute("length", dangFeiList.size());
        return "dangfei-list";
    }

    //缴纳党费页面
    @RequestMapping("/adddangfei")
    public String addDangfei() {
        return "dangfei-add";
    }

    //缴纳党费
    @RequestMapping("/dangfeiAdd")
    public String dangfeiAdd(HttpServletRequest request) {
        String bianhao = request.getParameter("bianhao");
        String name = request.getParameter("name");
        String idcard = request.getParameter("idcard");
        String zhibu = request.getParameter("zhibu");
        String time = DateUtil.getCurrentTimeByFormat("yyyy/MM/dd");
        Integer totalmoney = Integer.parseInt(request.getParameter("totalmoney"));
        dangFeiMapper.addDangfei(bianhao, name, idcard, zhibu, totalmoney, time);

        return "dangfeiDel-Success";
    }

    //党费缴纳记录页面
    @RequestMapping("/jiluPage")
    public String jiluPage() {
        return "dangfei-search";
    }

    @RequestMapping("/jilu")
    public String jilu(HttpServletRequest request, Model model) {
        String bianhao = request.getParameter("bianhao");
        List<DangFei> dangFeiList = dangFeiMapper.selectDangFeis(bianhao);
        model.addAttribute("list", dangFeiList);
        model.addAttribute("length", dangFeiList.size());
        return "dangfei-list";
    }
}
