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


    /**--------------------------------菜单 end----------------------------------------*/


}
