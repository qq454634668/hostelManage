package com.product.controller;

import com.product.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/test")
    @ResponseBody
    public  Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("roleId","5");
        result.put("data",userService.menuInfo(param));
        return result;
    }
    /**
     * @RequestParam 必填/@RequestParam(required=flase) 非必填
     * 登录
     * username   用户名
     * password   密码
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(HttpSession session,
                                    @RequestParam String username,
                                    @RequestParam String password){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("username",username);
            param.put("password",password);
            List<Map<String, Object>> userInfo = userService.userInfo(param);
            //用户信息存缓存
            if(userInfo.size()>0){
                Map a = userInfo.get(0);
                Object roleId = a.get("role_id");
                if(roleId!=null&&roleId!=""){
                    map.put("userInfo",userInfo);
                    param.put("roleId",roleId);
                    List<Map<String, Object>> menuInfo = userService.menuInfo(param);
                    map.put("menuInfo",menuInfo);
                    //查询权限下菜单
                    result.put("data",map);
                    result.put("message","登录成功");
                    result.put("code","200");
                }else{
                    //没有权限,不能登录
                    result.put("data",null);
                    result.put("message","该用户未授权,请联系管理员进行授权");
                    result.put("code","201");
                }
            }else{
                //用户不存在
                result.put("data",null);
                result.put("message","用户不存在");
                result.put("code","202");
            }

        }catch (Exception e){
            result.put("data",null);
            result.put("message","登录异常");
            result.put("code","500");
        }
        return result;
    }
    /**
     * 初始化登录，取用户缓存信息，活的菜单
     */
}
