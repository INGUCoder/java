package com.example.demo.Controller;
import com.example.demo.domain.Comments;
import com.example.demo.domain.Shichi;
import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.CommentsMapper;
import com.example.demo.repository.mapper.ShichiMappper;
import com.example.demo.repository.mapper.UserMapper;
import com.example.demo.repository.mapper.WordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user")//看这里  youcontroller结尾的  页面都在里面
public class UserController {
    //连接用户数据表
    @Autowired
    UserMapper userMapper;
    //连接诗词数据表
    @Autowired
    ShichiMappper shichiMappper;
    //连接留言板数据库
    WordsMapper wordsMapper;

    @Autowired
    CommentsMapper commentsMapper;
    //注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String birthdaty = request.getParameter("birthdaty");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        userMapper.insertUser(email,password,username,sex,age,birthdaty,phone,address);
        return "registerSuccess";
    }

    //登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users users = userMapper.selectByEmail(email);
        System.out.println(users.getEmail());
        System.out.println(users.getPassword());
        List<Comments> list1 = commentsMapper.selectComments();
        Integer nums = list1.size();
        if(users.getPassword().equals(password)&&users.getEmail().equals(email)){
            //创建session
            HttpSession session = request.getSession();
            //把账号密码保存在session里面
            session.setAttribute("username",users.getEmail());
            session.setAttribute("password",users.getPassword());
            List<Shichi> list = shichiMappper.selectAll();
            System.out.println(list.size());
            System.out.println("--------------------");
            model.addAttribute("nums",nums);
            model.addAttribute("commentslist",list1);
            model.addAttribute("allshichi",list);
            return "ccc";
        }
        return "loginFail";
        


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
    //用户修改个人信息
    @RequestMapping("/updateusers")
    public String updateusers(HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String address =request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Users users = userMapper.selectByEmail(email);
        
       if(users.getPassword().equals(password)){
           userMapper.update(username,newpassword,phone,address,email);
           return "upadateSuccess";

       }
       return "upadateFail1";



    }


//用户中心
    @RequestMapping("/userCenter")
    public String userCenter(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Users users = userMapper.selectByEmail(username);
        List<Shichi> zuozheList = shichiMappper.selectByZuozhe(users.getUsername());
        model.addAttribute("zuozheList",zuozheList);
        model.addAttribute("users",users);
        return "userinfo";


    }


    //用户信息查看修改
    @RequestMapping("/userInfo")
    public String  userInfo(HttpServletRequest request,Model model){
            String email  = request.getParameter("email");
            String password = request.getParameter("password");
            if(userMapper.selectByEmail(email).getPassword().equals(password)){
                Users user =  userMapper.selectByEmail(email);
                model.addAttribute("user",user);
                return "userinfo";
            }
            return "账户账号或者密码错误，请返回重新尝试";

    }

    //用户查看自己的诗词信息
    @RequestMapping("/userShichi")
    public String userShichi(HttpServletRequest request,Model model){

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(userMapper.selectByEmail(email).getPassword().equals(password)){

            List<Shichi> list = userMapper.userSearchShichi(userMapper.selectByEmail(email).getUsername());
            System.out.println("------------------");
            System.out.println(userMapper.selectByEmail(email).getUsername());
            System.out.println("------------------");
            model.addAttribute("allshichi",list);
            return "ccc";

        }
        //查询失败  然后显示这个空白页面
        return "ccc";
    }
}

    


