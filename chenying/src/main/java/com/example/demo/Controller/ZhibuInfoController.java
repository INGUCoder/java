package com.example.demo.Controller;

import com.example.demo.domain.zhibuinfo;
import com.example.demo.repository.mapper.ZhibuInfoMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/zhibu")
public class ZhibuInfoController {
    @Autowired
    ZhibuInfoMapper zhibuInfoMapper;
    //统一页面
    @RequestMapping("/showList")
    public String showList(Model model){
        List<zhibuinfo> list = zhibuInfoMapper.selectAll();
        model.addAttribute("length",list.size());
        model.addAttribute("zhibuinfo",list);
        return "zhibu-list";
    }
    //页面
    @RequestMapping("/add")
    public String Add(){
        return "zhibu-add";
    }
    //添加信息
    @RequestMapping("/addinfo")
    public  String AddInfo(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String bianhao = request.getParameter("bianhao");
        String people = request.getParameter("people");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        zhibuInfoMapper.inserInfo(name,bianhao,people,phone,address);
        List<zhibuinfo> list = zhibuInfoMapper.selectAll();
        model.addAttribute("length",list.size());
        model.addAttribute("zhibuinfo",list);
        return "zhibu-list";

    }
    //删除页面
    @RequestMapping("/delpage")
    public String delPage(){

        return "zhibu-del";
    }
    //删除支部信息
    @RequestMapping("/del")
    public String del(HttpServletRequest request){
        String bianhao = request.getParameter("bianhao");
        zhibuInfoMapper.deleteInfo(bianhao);
        return "zhibuDel-Success";
    }
    //修改页面
    @RequestMapping("/updatepage")
    public String udpdatePage(){
        return "zhibu-update";
    }
    //修改
    @RequestMapping("/update")
    public  String update(HttpServletRequest request){
        String name = request.getParameter("name");
        String bianhao = request.getParameter("bianhao");
        String people = request.getParameter("people");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        zhibuInfoMapper.updateInfo(name,people,phone,address,bianhao);
       return "zhibuUpdate-Success";

    }

    //查看页面
    @RequestMapping("/findPage")
    public  String findPage(){
        return "zhibu-search";
    }
    //查看支部信息
    @RequestMapping("/find")
    public  String find(HttpServletRequest request,Model model){
        String bianhao = request.getParameter("bianhao");
        zhibuinfo zhibu= zhibuInfoMapper.selectBybianhao(bianhao);
        model.addAttribute("zhibu",zhibu);
        return "zhibuInfo";
    }



}
