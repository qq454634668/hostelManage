package com.product.controller;

import com.product.service.UserService;
import com.product.util.AESUtil;
import com.product.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    private String userInfoKey="zsxt";


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
    public Map<String,Object> login(HttpSession session,HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("username", request.getParameter("username"));
            param.put("password",request.getParameter("password"));
            List<Map<String, Object>> userInfo = userService.userInfo(param);
            if(userInfo.size()>0){
                Map a = userInfo.get(0);
                Object roleId = a.get("role_id");
                if(roleId!=null&&roleId!=""){
//                    map.put("userInfo",userInfo.get(0));
                    //查询权限下菜单
//                    param.put("roleId",roleId);
//                    List<Map<String, Object>> menuInfo = userService.menuInfo(param);
//                    map.put("menuInfo",menuInfo);
                    //用户信息存缓存
//                    this.saveSessionUserInfo(session,userInfo.get(0));
                    String token = this.makeToken(a);
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String created_time = sdf.format(date);
                    param.put("token",token);
                    param.put("scsj",created_time);
                    param.put("user_id",a.get("id"));
                    userService.insertToken(param);
                    result.put("data",token);
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
    private String makeToken(Map<String, Object> userInfo){
        String id = userInfo.get("id").toString();
        String username = userInfo.get("username").toString();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        String token = id+username+created_time;
        return AESUtil.getInstance().encode(token,userInfoKey);
    }
    private String getUserId(String token){
        //        解码后的token
        String jmtoken = AESUtil.getInstance().decode(token,userInfoKey);
        String[] tokenList  =jmtoken.split("#");
        return tokenList[0];
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
     * 验证token时效性
     * token
     */
    @RequestMapping("/InitInfo")
    @ResponseBody
    public Map<String,Object> InitInfo(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String  token = request.getHeader("token");
//            String  token = "5413FA52ED9B928C64E1A16435FB125807C6E3B97B5F9691E28BFBFA8F2422A6";
            System.out.print(token);
            if(token.isEmpty()){
                result.put("data",null);
                result.put("message","用户信息不存在,请重新登录");
                result.put("code","201");
            }else{
                param.put("token",token);
//                String userId = this.getUserId(token);
                List<Map<String,Object>> list = userService.getUserInfoId(param);
                if(list.size()!=0){
                    Map<String,Object> user = list.get(0);
//                    //验证token时效性
//                    Object scsj = user.get("scsj");  //生成时间
//                    Date now = new Date();
//                    Date tmp = DateTimeUtils.timeStringToDate(scsj.toString(),"yyyyMMddHHmmss");
//                    long hour = (now.getTime() - tmp.getTime()) / (1000 * 3600);  //当前时间和token生成时间相差小时
                    Object userId = user.get("user_id");
                    param.put("userId",userId);
                    List<Map<String,Object>> userInfoList = userService.userInfoId(param);
                    Map<String,Object> userInfo = userInfoList.get(0);
                    Object roleId = userInfo.get("role_id");
                    map.put("userInfo",userInfo);
                    //查询权限下菜单
                    param.put("roleId",roleId);
                    List<Map<String, Object>> menuInfo = userService.menuInfo(param);
                    map.put("menuInfo",menuInfo);
                    result.put("data",map);
                    result.put("message","用户信息获取成功");
                    result.put("code","200");
                }else{
                    result.put("data",null);
                    result.put("message","用户信息获取失败");
                    result.put("code","201");
                }
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
     * 不需要接退出登录
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
