package com.example.demo.service;

import com.example.demo.domain.Users;

import com.example.demo.repository.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public Map<String,Object> PageShow(int limit, int offset){
        Map<String,Object> map = new HashMap<>();
        List<Users> page = new ArrayList<>();
        List<Users> all = userMapper.allUsers();
        for (int i=offset;i<limit+offset;i++){
            if(i<all.size()){
                page.add(all.get(i));
            }
        }
        map.put("rows",page);
        map.put("total",all.size());

        return map;

    }




}
