package com.example.demo.Controller;

import com.example.demo.domain.Comments;
import com.example.demo.domain.Shichi;
import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.CommentsMapper;
import com.example.demo.repository.mapper.ShichiMappper;
import com.example.demo.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shichi")
public class ShichiController {
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    ShichiMappper shichiMappper;
    //推荐诗文
    @Autowired
    UserMapper  userMapper;
    @RequestMapping("/type1")
    public String Type1(Model model, HttpServletRequest request){
        String type = request.getParameter("shichiname");
        List<Shichi> list = shichiMappper.searchShichiType(type);
        System.out.println(list.size());
        System.out.println("---------------------------------");
        System.out.println(type);
        model.addAttribute("allshichi",list);

        return  "ccc";
    }

    //图片标签
    @RequestMapping("/type2")
    public String Type2(Model model, HttpServletRequest request){

        String type = "清明";
        List<Shichi> list = shichiMappper.searchShichiType(type);
        System.out.println(list.size());
        System.out.println("---------------------------------");
        System.out.println(type);
        model.addAttribute("allshichi",list);

        return  "ccc";
    }
    //搜索诗文
    @RequestMapping("/search")
    public String Search(Model model,HttpServletRequest request){
        String name = request.getParameter("zuopingming");
        System.out.println(name);
        System.out.println("------------------");
        //System.out.println(shichiMappper.test(1).getZuopingming());

       // Shichi shichi =  shichiMappper.searchShichi(name);
        List<Shichi> shichi = shichiMappper.searchShichiList(name);
        if(shichi.size()>0){
            model.addAttribute("allshichi",shichi);
            return "ccc";
        }

        return "SearchFail1";
    }
    //用户发布诗词成功后页面
    @RequestMapping("/usersFabu")
    public String usersFabu(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("username");

        Users users = userMapper.selectByEmail(email);
        List<Shichi> list = shichiMappper.selectByZuozhe(users.getUsername());



        model.addAttribute("allshichi",list);
        return "ccc";


    }



    //用户发布个人诗词
    @RequestMapping("/userInsertShichi")
    public String userInsertShichi(HttpServletRequest request,Model model){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String zuopingming = request.getParameter("zuopingming");
        String zuozhe = request.getParameter("zuozhe");
        String zuopinginfo = request.getParameter("zuopinginfo");
        String shichitype= request.getParameter("shichitype");
        String zhushi = request.getParameter("zhushi");
        String zuozheinfo = "网站作者";
        if(userMapper.selectByEmail(email).getPassword().equals(password)){
            userMapper.usersInsertShichi(zuopingming,zuozhe,zuopinginfo,shichitype,zuozheinfo,zhushi);
            Shichi shichi = shichiMappper.searchShichi(zuopingming);
            model.addAttribute("allshichi",shichi);
            return "ccc";

        }
        return "userinsertFail";


    }
    //修改诗词页面
    @RequestMapping("/alter")
    public  String alterShichi(){

        return "shichi-alter";
    }

    //点赞处理
    @RequestMapping("/dianzhan")
    public String dianZhan(HttpServletRequest request,Model model){
        String dianzhan = request.getParameter("dianzhan");
        String name = request.getParameter("shichi.zuopingming");
        Integer dianzhan1 = Integer.parseInt(dianzhan);
        //点一下 加1  点赞
        dianzhan1 = dianzhan1 + 1;
        shichiMappper.dianZhan(dianzhan1,name);
        List<Shichi> list = shichiMappper.selectAll();
        List<Comments> list1 = commentsMapper.selectAllComments(name);
        Integer nums = list1.size();
        model.addAttribute("allshichi",list);
        model.addAttribute("nums",nums);

        System.out.println("----------------");
        System.out.println("---TEST--------");
        System.out.println(dianzhan1);
        System.out.println(dianzhan);
        System.out.println("--------------");
        return "ccc";
    }


}
