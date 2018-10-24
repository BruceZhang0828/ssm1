package com.zhy.ssm1.controller;

import com.zhy.ssm1.domain.User;
import com.zhy.ssm1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    UserMapper userMapper; //代理模式
    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }

    @ResponseBody
    @RequestMapping("/get")
    public User get(Integer id){

        return userMapper.get(id);
    }
}
