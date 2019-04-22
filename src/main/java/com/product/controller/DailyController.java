package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.DailyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日常管理功能
 */
@Controller
@RequestMapping("/daily")
public class DailyController {
    @Resource
    private DailyService dailyService;



    /**--------------------------------入住管理 start----------------------------------------*/
    /**
     * 床位按楼的一个根据fjbh分组的list
     * xqbh 校区编号（可以为空,默认查询传空）
     * gybh 公寓编号（可以为空,默认查询传空）
     *loubh 楼编号  （默认选中第一个，传第一个） 01
     */
    @RequestMapping("/BedListMap")
    @ResponseBody
    public Map<String,Object> BedListMap(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String xqbh = request.getParameter("xqbh");
            String loubh = request.getParameter("loubh");
            String gybh = request.getParameter("gybh");
            param.put("loubh",loubh);
            param.put("xqbh",xqbh);
            param.put("gybh",gybh);
            result.put("data",dailyService.BedListMap(param));
            result.put("message","床位查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","床位查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     *学生列表
     * zszt：住宿状态   1---未入住(入住)   2---已入住（--换宿/退宿）
     * xy  学院
     * zy 专业
     * nj 年级
     * bj  班级
     */
    @RequestMapping("/StudentList")
    @ResponseBody
    public Map<String,Object> StudentList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            String zszt = request.getParameter("zszt");
            String xy = request.getParameter("xy");
            String zy = request.getParameter("zy");
            String nj = request.getParameter("nj");
            String bj = request.getParameter("bj");
            param.put("zszt",zszt);
            param.put("xy",xy);
            param.put("zy",zy);
            param.put("nj",nj);
            param.put("bj",bj);
            list = dailyService.StuList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","学生列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","学生列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *点击床位入住
     */
    @RequestMapping("/MoveInto")
    @ResponseBody
    public Map<String,Object> MoveInto(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();

        return result;
    }
    /**--------------------------------入住管理 end----------------------------------------*/


}
