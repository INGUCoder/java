package com.example.demo;

import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Test
	public void contextLoads() {
	}
	@Test
	public void getUsers(){


	}

}

