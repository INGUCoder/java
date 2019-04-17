package com.mazheng.chat.dao;

import com.mazheng.chat.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;



/**
 * 处理用户登陆
 * @author mazheng
 * @date 2019/4/47
 */
public class DaoTools {
    /**
     * 储存账号和密码
     */
    private static Map<String,String> userDB = new HashMap<>();
    @Autowired
    UserMapper userMapper;

    public  boolean check(Users users,String email){
        System.out.println(users+email);
        userDB.put(userMapper.selectByEmail(email).getEmail(),userMapper.selectByEmail(email).getPassword());
        /**
         * 检查数据库中是否含有这个用户
         *
         */
        if(userDB.containsKey(email)&&userDB.containsKey(users.getPassword())){
                return true;
        }
        System.out.println(users.getUsername()+"用户账号或者密码错误");
        return false;
    }


}
