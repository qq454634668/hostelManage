package com.product.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.product.service.PurviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限功能
 */
@Controller
@RequestMapping("/purview")
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


    /**--------------------------------角色 end--------------------------------------*/
}
