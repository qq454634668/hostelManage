package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.LiveService;
import com.product.util.CodeMakeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 住宿管理功能
 */
@Controller
@RequestMapping("/live")
public class LiveController {
    @Resource
    private LiveService liveService;




    /**--------------------------------校区管理 start----------------------------------------*/

    /**
     * 添加校区
     * name  校区名称
     */
    @RequestMapping("/AddCampus")
    @ResponseBody
    public Map<String,Object> AddCampus(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            param.put("rksj",created_time);
            param.put("name",name);
            liveService.AddCampus(param);
            result.put("data",null);
            result.put("message","校区添加成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区添加失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 修改校区
     * name  校区名称
     * id
     */
    @RequestMapping("/EditCampus")
    @ResponseBody
    public Map<String,Object> EditCampus(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            param.put("rksj",created_time);
            param.put("id",id);
            param.put("name",name);
            liveService.EditCampus(param);
            result.put("data",null);
            result.put("message","校区修改成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区修改失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 删除校区
     * id
     */
    @RequestMapping("/DeleteCampus")
    @ResponseBody
    public Map<String,Object> DeleteCampus(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            liveService.DeleteCampus(param);
            result.put("data",null);
            result.put("message","校区删除成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区删除失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 是否存在公寓
     * 本校区下是否存在公寓区
     * bh  校区编号
     */
    @RequestMapping("/ExistApartment")
    @ResponseBody
    public Map<String,Object> ExistApartment(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String bh = request.getParameter("bh");
            param.put("bh",bh);
            result.put("data",liveService.ExistApartment(param));
            result.put("message","是否存在公寓查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","是否存在公寓查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 校区列表
     * pageNum
     * pageSize
     */
    @RequestMapping("/QueryCampusList")
    @ResponseBody
    public Map<String,Object> QueryUserList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            list = liveService.QueryCampusList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","校区列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**--------------------------------校区管理 end----------------------------------------*/




}
