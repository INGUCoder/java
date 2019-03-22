package com.example.demo.Controller;
import com.example.demo.domain.Shichi;
import com.example.demo.domain.Users;
import com.example.demo.domain.Words;
import com.example.demo.repository.mapper.ShichiMappper;
import com.example.demo.repository.mapper.UserMapper;
import com.example.demo.repository.mapper.WordsMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {
    //连接用户数据表
    @Autowired
    UserMapper userMapper;
    //连接诗词数据表
    @Autowired
    ShichiMappper shichiMappper;
    //连接留言板数据库
    WordsMapper wordsMapper;
    //注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request) {

        String email = request.getParameter("email");
        String nicheng = request.getParameter("nicheng");
        String password = request.getParameter("password");
        userMapper.insertUser(email, nicheng, password);

        return "registerSuccess";
    }

    //登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        Users users = userMapper.selectByEmail(email);
        System.out.println(users.getEmail());
        System.out.println(users.getPassword());
        System.out.println(request.getParameter("password"));
        if(users.getPassword().equals(password)&&users.getEmail().equals(email)){
            return "loginSuccess";
        }
        return "loginFail";
        


    }

    //查询结果
    @RequestMapping("/allEnd")
    public String allEnd(HttpServletRequest request, ModelMap map) {



        Shichi shichi = shichiMappper.selectByZuopingming(request.getParameter("zuopingming"));
        System.out.println(shichi.getZuopingming());
        //根据诗词名来搜索诗词
        if (shichi.getZuopingming().equals(request.getParameter("zuopingming"))) {




                map.addAttribute("zuopingming", shichi.getZuopingming());
                map.addAttribute("zuozhe", shichi.getZuoche());
                map.addAttribute("zuopinginfo", shichi.getZuopinginfo());
                map.addAttribute("zuozheinfo", shichi.getZuozheinfo());


                return "main";
        }
        else {
            return "error";
        }

    }
    //留言板
    @RequestMapping("/words")
    public String words(HttpServletRequest request){
        String nicheng  = request.getParameter("nicheng");
        String words = request.getParameter("words");
        System.out.println(nicheng);
        System.out.println(words);
        wordsMapper.insertWords(nicheng,words);
        return "index";

    }
    //修改个人信息
    @RequestMapping("/updateusers")
    public String updateusers(HttpServletRequest request){

        String nicheng = request.getParameter("nicheng");
        String oldpassword = request.getParameter("oldpassword");
        String password = request.getParameter("password");
        System.out.println(oldpassword);
        System.out.println(password);
        String email = request.getParameter("email");
        Users users = userMapper.selectByEmail(email);
        
        if(oldpassword.equals(users.getPassword())){
            userMapper.update(nicheng,password,email);
            return "login";
        }else if (users==null){
            return "UpdateFail";
        } else {
            return "UpdateFail";
        }



    }
}

    


