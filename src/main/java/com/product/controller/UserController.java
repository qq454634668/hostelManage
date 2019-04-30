package com.product.controller;

import com.product.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // customer用户端
    /**
     *
     * @param c_userid  登录用户名
     * @return   返回结果   返回0是用户不存在，1是用户存在
     */
    @RequestMapping("/customer/existUser")
    @ResponseBody
    public int existUser(String c_userid){
        Map<String,Object> param = new HashMap<>();
        param.put("c_userid",c_userid);
        int exist = userService.existUser(param);
        return exist;
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>();
        return result;
    }







}
