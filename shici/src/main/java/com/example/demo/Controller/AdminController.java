
package com.example.demo.Controller;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Shichi;
import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.AdminMapper;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserMapper  userMapper;
    @Autowired
    WordsMapper wordsMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ShichiMappper shichiMappper;


    //管理员登录 查询所有用户
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model){

        HttpSession session1 = request.getSession(false);
        if (session1!=null){
            List<Users> list = userMapper.selectAll();
            int nums = list.size();
            model.addAttribute("nums",nums);
            model.addAttribute("users",list);
            return "member-list";
        }

        String name = request.getParameter("email") ;
        String password = request.getParameter("password");
        Admin admin = adminMapper.select(name);

        if(name.equals(admin.getName())&&password.equals(admin.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("admin",name);
            List<Users> list = userMapper.selectAll();
            int nums = list.size();
            model.addAttribute("nums",nums);
            model.addAttribute("users",list);
            return "member-list";

        }  else {
            return "adminLogin";
        }

    }
    //管理员登陆 查询所有诗词
    @RequestMapping("/selectAllShichi")
    public String selectAllShichi(Model model){
        List<Shichi> list = adminMapper.selectAllShichi();
        int nums = list.size();
        model.addAttribute("nums",nums);
        model.addAttribute("shichi",list);
        return "shichi-list";
    }
    //查询所有用户信息
    @RequestMapping("/select")
    public  String select(HttpServletRequest request){
        return "null";

    }
    //删除垃圾评论
    @RequestMapping("/deletewords")
    public String deletewords(HttpServletRequest request){
        wordsMapper.delete(request.getParameter("userswords"));
        return "adminsuccess";
    }
    //插入诗词信息
    @RequestMapping("/insert")
    public String update(HttpServletRequest request,Model model){
        HttpSession session = request.getSession(false);
        String zuozhe = (String) session.getAttribute("username");
        Users users =  userMapper.selectByEmail(zuozhe);
        String  zuopingming = request.getParameter("zuopingming");
        String  zuopinginfo=request.getParameter("zuopinginfo");
        String  zhushi = request.getParameter("zhushi");
        String zuozheinfo = "网站作者";
        String  type= "用户创作";
        userMapper.usersInsertShichi(zuopingming,users.getUsername(),zuopinginfo,type,zuozheinfo,zhushi);
        model.addAttribute("info1","添加诗词成功，点击返回");
        model.addAttribute("info2","/user/login");
        return "shichi-add-success";

    }
    //管理员添加诗词
    @RequestMapping("/adminInsert")
    public String adminUpdate(HttpServletRequest request, Model model){

        String  zuopingming = request.getParameter("zuopingming");
        String  zuopinginfo = request.getParameter("zuopinginfo");
        String  zuozhe = request.getParameter("zuozhe");
        String  zuozheinfo = request.getParameter("zuozheinfo");
        String  zhushi = request.getParameter("zhushi");
        String  shichitype = request.getParameter("shichitype");
        userMapper.usersInsertShichi(zuopingming,zuozhe,zuopinginfo,shichitype,zuozheinfo,zhushi);
        model.addAttribute("info1","添加诗词成功，点击返回");
        model.addAttribute("info2","/admin/selectAllShichi");
        return "shichi-add-success";
    }


    //添加用户
    @RequestMapping("/adduser")
    public String addUser(HttpServletRequest request){

        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        session.setAttribute("email",email);
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String birthdaty = request.getParameter("birthdaty");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        userMapper.insertUser(email,password,username,sex,age,birthdaty,phone,address);
         return    "member-add-success";
    }
//添加诗词
    @RequestMapping("/addshichi")
    public  String addshichi(HttpServletRequest request){
        String zuopingming = request.getParameter("zuopingming");
        String zuozhe = request.getParameter("zuozhe");
        String zuopinginfo = request.getParameter("zuopinginfo");
        String shichitype= request.getParameter("shichitype");
        String zuozheinfo = request.getParameter("zuozheinfo");
        String zhushi = request.getParameter("zhushi");
        userMapper.usersInsertShichi(zuopingming,zuozhe,zuopinginfo,shichitype,zuozheinfo,zhushi);
        return "adminLogin";
}
//修改诗词
    @RequestMapping("/altershichi")
    public String altershichi(HttpServletRequest request){
        String zuopingming = request.getParameter("zuopingming");
        String zuozhe = request.getParameter("zuozhe");
        String zuopinginfo = request.getParameter("zuopinginfo");
        String shichitype= request.getParameter("shichitype");
        String zuozheinfo = request.getParameter("zuozheinfo");
        String zhushi = request.getParameter("zhushi");
        System.out.println("------Test----------------");
        System.out.println(zuopingming+zuozhe+zuopinginfo+shichitype+zuozheinfo+zhushi);
        userMapper.updateShichi(zuozhe,zuopinginfo,shichitype,zuozheinfo,zhushi,zuopingming);
        return "ShiCHiUpdateSuccess";
    }
    //删除用户
    @RequestMapping("/admindel")
    public  String admindel(HttpServletRequest request){
        String email =  request.getParameter("email");
        adminMapper.deleteUser(email);
        return "adminLogin";
    }
    //删除诗词
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request){
        String zuopingming = request.getParameter("zuopingming");
        System.out.println(zuopingming);
        adminMapper.deleteShichi(zuopingming);


        return "adminLogin";
    }
    //用户中心
    @RequestMapping("/userCenter")
    public String userCenter(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        Users users = userMapper.selectByEmail(email);
        System.out.println(users);
        List<Shichi> zuozheList = shichiMappper.selectByZuozhe(users.getUsername());
        model.addAttribute("zuozheList",zuozheList);
        model.addAttribute("users",users);
        return "userinfo";

    }


    /**
     * 管理员删除数据
     */
    @RequestMapping("/shanchuId")
    public String shanchuId(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("deleteId"));
        adminMapper.deleteUserId(id);
        System.out.println(id);
        List<Users> list = userMapper.selectAll();
        int nums = list.size();
        model.addAttribute("nums",nums);
        model.addAttribute("users",list);
        return "member-list";
    }

    /**
     * 管理员删除诗词
     */

    @RequestMapping("/shanchuShci")
    public String shanchuShici(HttpServletRequest request,Model model){
        int  id = Integer.parseInt(request.getParameter("deleteShiciId"));
        System.out.println(id);
        adminMapper.deleteShiciId(id);

        List<Shichi> list = adminMapper.selectAllShichi();
        int nums = list.size();
        model.addAttribute("nums",nums);
        model.addAttribute("shichi",list);
        return "shichi-list";



    }

    /**
     * 管理员修改用户信息
     */

    @RequestMapping("/updateUser")
    public String  updateUser(HttpServletRequest request, Model model){

        String email = request.getParameter("email");
        if (userMapper.selectByEmail(email)!=null) {

            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String sex = request.getParameter("sex");
            Integer age = Integer.parseInt(request.getParameter("age"));
            String birthdaty = request.getParameter("birthdaty");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            adminMapper.updateUser(username,password,sex,age,birthdaty,phone,address,email);
            model.addAttribute("success1","修改用户信息成功,点击返回");
            System.out.println("------Test-------");
            model.addAttribute("successhref1","/admin/selectAllShichi");
            return "successPage";

        }
        return "errorPage";





    }

}







