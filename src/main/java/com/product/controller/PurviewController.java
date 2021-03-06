package com.product.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.product.service.PurviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 权限管理功能
 */
@Controller
@RequestMapping("/purview")
@CrossOrigin
public class PurviewController {
    @Resource
    private PurviewService purviewService;



    @RequestMapping("/example")
    @ResponseBody
    public Map<String,Object> example(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("message","调用成功");
            result.put("code","200");
            result.put("data",null);
//            List<Map<String,Object>> list=new ArrayList<>();
//            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
//            result.put("data",pageList);

//            Date date = new Date();   时间创建
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            String created_time = sdf.format(date);
        }catch (Exception e){
            result.put("message","调用失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**--------------------------------菜单 start----------------------------------------*/

    /**
     * 增加菜单
     * @parent_id
     * @name  菜单名
     * @url
     * @icon  图标
     * @px   排序
     */
    @RequestMapping("/AddMenu")
    @ResponseBody
    public Map<String,Object> AddMenu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String parent_id = request.getParameter("parent_id");
            String name = request.getParameter("name");
            String url = request.getParameter("url");
            String icon = request.getParameter("icon");
            String px = request.getParameter("px");
            param.put("parent_id",parent_id);
            param.put("name",name);
            param.put("url",url);
            param.put("icon",icon);
            param.put("px",px);
            purviewService.AddMenu(param);
            result.put("message","添加菜单成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","添加菜单失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 修改菜单
     * @id
     * @name
     * @url
     * @icon
     * @px
     */
    @RequestMapping("/EditMenu")
    @ResponseBody
    public Map<String,Object> EditMenu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String url = request.getParameter("url");
            String icon = request.getParameter("icon");
            String px = request.getParameter("px");
            param.put("id",id);
            param.put("name",name);
            param.put("url",url);
            param.put("icon",icon);
            param.put("px",px);
            purviewService.EditMenu(param);
            result.put("message","修改菜单成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","修改菜单失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 查询菜单
     * 查询树状结构菜单
     */
    @RequestMapping("/QueryMenu")
    @ResponseBody
    public Map<String,Object> QueryMenu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> param = new HashMap<>();
        try{
//            String name = request.getParameter("name");
//            param.put("name",name);
            List<Map<String, Object>> resultList = purviewService.QueryMenu(param);
            result.put("message","菜单查询成功");
            result.put("code","200");
            result.put("data",resultList);
        }catch (Exception e){
            result.put("message","菜单查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }


    /**
     *删除菜单
     * @id
     */
    @RequestMapping("/DeleteMenu")
    @ResponseBody
    public Map<String,Object> DeleteMenu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            purviewService.DeleteMenu(param);
            result.put("message","删除菜单成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","删除菜单失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**--------------------------------菜单 end----------------------------------------*/




    /**--------------------------------角色 start--------------------------------------*/

    /**
     * 可选择菜单列表
     */
    @RequestMapping("/SelectMenu")
    @ResponseBody
    public Map<String,Object> SelectMenu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",purviewService.SelectMenu(param));
            result.put("message","可选择菜单列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","可选择菜单列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 创建角色
     * @role_name 角色名
     * @menu_id   菜单ID（例子:1,2,3,4）
     */
    @RequestMapping("/AddRole")
    @ResponseBody
    public Map<String,Object> AddRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String role_name = request.getParameter("role_name");
            String menu_id = request.getParameter("menu_id");
            param.put("role_name",role_name);
            param.put("menu_id",menu_id);
            purviewService.AddRole(param);
            result.put("message","创建角色成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","创建角色失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }


//    /**
//     * 修改角色  --修改角色名
//     * role_name
//     * id
//     */
//    @RequestMapping("/EditRoleName")
//    @ResponseBody
//    public Map<String,Object> EditRoleName(HttpServletRequest request){
//        Map<String,Object> result = new HashMap<>();
//        Map<String,Object> param = new HashMap<>();
//        try{
//            String role_name = request.getParameter("role_name");
//            String id = request.getParameter("id");
//            param.put("role_name",role_name);
//            param.put("id",id);
//            purviewService.EditRoleName(param);
//            result.put("message","修改角色名成功");
//            result.put("code","200");
//            result.put("data",null);
//        }catch (Exception e){
//            result.put("message","修改角色名失败");
//            result.put("code","500");
//            result.put("data",e.getMessage());
//        }
//        return result;
//    }
//    /**
//     * 修改角色  --修改角色菜单（权限）
//     * role_id
//     * menu_id
//     */
//    @RequestMapping("/EditRoleMenu")
//    @ResponseBody
//    public Map<String,Object> EditRoleMenu(HttpServletRequest request){
//        Map<String,Object> result = new HashMap<>();
//        Map<String,Object> param = new HashMap<>();
//        try{
//            String role_id = request.getParameter("role_id");
//            String menu_id = request.getParameter("menu_id");
//            param.put("role_id",role_id);
//            param.put("menu_id",menu_id);
//            purviewService.EditRoleMenu(param);
//            result.put("message","修改角色菜单成功");
//            result.put("code","200");
//            result.put("data",null);
//        }catch (Exception e){
//            result.put("message","修改角色菜单失败");
//            result.put("code","500");
//            result.put("data",e.getMessage());
//        }
//        return result;
//    }
    /**
     * 修改角色
     * role_id
     * menu_id
     * role_name
     */
    @RequestMapping("/EditRole")
    @ResponseBody
    public Map<String,Object> EditRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String role_id = request.getParameter("role_id");
            String menu_id = request.getParameter("menu_id");
            String role_name = request.getParameter("role_name");
            param.put("role_id",role_id);
            param.put("menu_id",menu_id);
            param.put("role_name",role_name);
            purviewService.EditRole(param);
            result.put("message","修改角色成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","修改角色失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 删除角色
     * id
     */
    @RequestMapping("/DeleteRole")
    @ResponseBody
    public Map<String,Object> DeleteRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("role_id",id);
            purviewService.DeleteRole(param);
            result.put("message","删除角色成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","删除角色失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }



    /**
     * 角色是否存在关联用户
     * id
     * data等于0没有相关用户可以删除，大于0有相关用户不允许删除
     */
    @RequestMapping("/ExistRoleUser")
    @ResponseBody
    public Map<String,Object> ExistRoleUser(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("role_id",id);
            int length= purviewService.ExistRoleUser(param);
            result.put("message","角色是否存在关联用户查询成功");
            result.put("code","200");
            result.put("data",length);
        }catch (Exception e){
            result.put("message","删除角色角色是否存在关联用户查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 角色列表
     */
    @RequestMapping("/RoleList")
    @ResponseBody
    public Map<String,Object> RoleList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",purviewService.RoleList(param));
            result.put("message","角色列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","角色列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**--------------------------------角色 end--------------------------------------*/

    /**--------------------------------用户 start--------------------------------------*/


    /**
     * 新增用户
     * @username  用户名
     * @password  密码
     * @realname  真实姓名
     * @lxdh      联系电话
     * @xy        学院
     * @nj        年级（入学年份）
     */
    @RequestMapping("/AddUser")
    @ResponseBody
    public Map<String,Object> AddUser(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String realname = request.getParameter("realname");
            String lxdh = request.getParameter("lxdh");
            String xy = request.getParameter("xy");
            String nj = request.getParameter("nj");
            param.put("username",username);
            param.put("password",password);
            param.put("realname",realname);
            param.put("lxdh",lxdh);
            param.put("xy",xy);
            param.put("nj",nj);
            param.put("rksj",created_time);
            purviewService.AddUser(param);
            result.put("message","添加用户成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","添加用户失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 用户授权
     * @id  用户ID
     * @role_id  角色ID
     */
    @RequestMapping("/AddUserRole")
    @ResponseBody
    public Map<String,Object> AddUserRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String user_id = request.getParameter("id");
            String role_id = request.getParameter("role_id");
            param.put("user_id",user_id);
            param.put("role_id",role_id);
            purviewService.AddUserRole(param);
            result.put("message","用户授权成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","用户授权失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 用户删除
     * @id  用户ID
     */
    @RequestMapping("/DeleteUser")
    @ResponseBody
    public Map<String,Object> DeleteUser(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String user_id = request.getParameter("id");
            param.put("user_id",user_id);
            purviewService.DeleteUser(param);
            result.put("message","用户删除成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","用户删除失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 修改用户 --修改用户基本信息
     * @realname  真实姓名
     * @lxdh      联系电话
     * @xy        学院
     * @nj        年级（入学年份）
     * @id        用户ID
     */
    @RequestMapping("/EditUser")
    @ResponseBody
    public Map<String,Object> EditUser(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String user_id = request.getParameter("id");
            param.put("user_id",user_id);
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
            String realname = request.getParameter("realname");
            String lxdh = request.getParameter("lxdh");
            String xy = request.getParameter("xy");
            String nj = request.getParameter("nj");
//            param.put("username",username);
//            param.put("password",password);
            param.put("realname",realname);
            param.put("lxdh",lxdh);
            param.put("xy",xy);
            param.put("nj",nj);
            param.put("rksj",created_time);
            purviewService.EditUser(param);
            result.put("message","修改用户 --修改用户基本信息成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","修改用户 --修改用户基本信息失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 修改用户 --修改用户授权RoleList
     * @id  用户ID
     * @role_id  角色ID
     */
    @RequestMapping("/EditUserRole")
    @ResponseBody
    public Map<String,Object> EditUserRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String user_id = request.getParameter("id");
            String role_id = request.getParameter("role_id");
            param.put("user_id",user_id);
            param.put("role_id",role_id);
            purviewService.EditUserRole(param);
            result.put("message","修改用户 --修改用户基本信息成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","修改用户 --修改用户基本信息失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }


    /**
     * 用户列表
     * key   （用户名，真实姓名，手机号模糊搜索）
     * pageNum
     * pageSize
     */
    @RequestMapping("/QueryUserList")
    @ResponseBody
        public Map<String,Object> QueryUserList( HttpServletRequest request, int pageNum, int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            String key = request.getParameter("key");
            if(key!=null &&key!=""){
                param.put("key",'%'+key+'%');
            }else{
                param.put("key","");
            }

            list = purviewService.QueryUserList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","调用成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","调用失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**--------------------------------用户 end--------------------------------------*/
}
