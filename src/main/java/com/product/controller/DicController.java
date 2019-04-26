package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.DicService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 字典管理
 * 下拉框和字典查询
 */
@Controller
@RequestMapping("/dic")
public class DicController {
    @Resource
    private DicService dicService;

    /**
     * 校区字典
     */
    @RequestMapping("/DicCampus")
    @ResponseBody
    public Map<String,Object> DicCampus(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",dicService.DicCampus(param));
            result.put("message","校区字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 公寓字典
     * xqbh 校区编号
     */
    public Map<String,Object> DicApartment(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        return result;
    }

}
