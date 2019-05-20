package com.product.controller;

import com.product.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;


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
     * @RequestParam 必填/@RequestParam(required=false) 非必填
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
            if(userInfo.size()>0){
                Map a = userInfo.get(0);
                Object roleId = a.get("role_id");
                if(roleId!=null&&roleId!=""){
                    map.put("userInfo",userInfo.get(0));
                    //查询权限下菜单
//                    param.put("roleId",roleId);
//                    List<Map<String, Object>> menuInfo = userService.menuInfo(param);
//                    map.put("menuInfo",menuInfo);
                    //用户信息存缓存
                    this.saveSessionUserInfo(session,userInfo.get(0));
                    result.put("data",map);
                    result.put("message","登录成功");
                    result.put("code","200");
                }else{
                    //没有权限,不能登录
                    result.put("data",null);
                    result.put("message","该用户未授权,请联系管理员进行授权,再进行重新登录");
                    result.put("code","201");
                }
            }else{
                //用户不存在
                result.put("data",null);
                result.put("message","用户不存在,请核对账号密码重新登录");
                result.put("code","202");
            }

        }catch (Exception e){
            result.put("data",null);
            result.put("message","登录异常");
            result.put("code","500");
        }
        return result;
    }

    private void saveSessionUserInfo(HttpSession session,Map<String, Object> userInfo){
        Object id = userInfo.get("id");
        Object lxdh = userInfo.get("lxdh");
        Object nj = userInfo.get("nj");
        Object realname = userInfo.get("realname");
        Object role_id = userInfo.get("role_id");
        Object rolename = userInfo.get("rolename");
        Object username = userInfo.get("username");
        Object xy = userInfo.get("xy");
        session.setAttribute("id",id);
        session.setAttribute("lxdh",lxdh);
        session.setAttribute("nj",nj);
        session.setAttribute("realname",realname);
        session.setAttribute("role_id",role_id);
        session.setAttribute("rolename",rolename);
        session.setAttribute("username",username);
        session.setAttribute("xy",xy);
    }
    private Map<String,Object> getSessionUserInfo(HttpSession session){
        Map<String, Object> userInfo = new HashMap<>();
        try{
            Object id = session.getAttribute("id");
            Object lxdh = session.getAttribute("lxdh");
            Object nj = session.getAttribute("nj");
            Object realname = session.getAttribute("realname");
            Object role_id = session.getAttribute("role_id");
            Object rolename = session.getAttribute("rolename");
            Object username = session.getAttribute("username");
            Object xy = session.getAttribute("xy");
            if(id==""||id==null){
                //如果ID为空,直接返回空userInfo
                return userInfo;
            }else{
                userInfo.put("id",id);
                userInfo.put("lxdh",lxdh);
                userInfo.put("nj",nj);
                userInfo.put("realname",realname);
                userInfo.put("role_id",role_id);
                userInfo.put("rolename",rolename);
                userInfo.put("username",username);
                userInfo.put("xy",xy);
                return userInfo;
            }
        }catch (NullPointerException e){
            System.out.println("用户信息获得=====NullPointerException");
            return userInfo;
        }
    }

    /**
     * 初始化登录，取用户缓存信息，活的菜单
     */
    @RequestMapping("/InitInfo")
    @ResponseBody
    public Map<String,Object> InitInfo(HttpSession session){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            Map<String, Object> userInfo = this.getSessionUserInfo(session);
            if(userInfo.isEmpty()){
                result.put("data",null);
                result.put("message","用户信息不存在,请重新登录");
                result.put("code","201");
            }else{
                Object roleId = userInfo.get("role_id");
                map.put("userInfo",userInfo);
                //查询权限下菜单
                param.put("roleId",roleId);
                List<Map<String, Object>> menuInfo = userService.menuInfo(param);
                map.put("menuInfo",menuInfo);
                result.put("data",map);
                result.put("message","用户信息获取成功");
                result.put("code","200");
            }
        }catch (Exception e){
            result.put("data",null);
            result.put("message","登录异常");
            result.put("code","500");
        }
        return result;
    }

    /**
     * 退出登录
     */
    @RequestMapping("/QuitLogin")
    @ResponseBody
    public Map<String,Object> QuitLogin(HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try{
            session.invalidate();
            result.put("data",null);
            result.put("message","退出登录成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data",null);
            result.put("message","退出登录失败");
            result.put("code","500");
        }
        return result;
    }

}
