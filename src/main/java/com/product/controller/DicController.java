package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.DicService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
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
     * code 校区编号(页面菜单获取下级菜单统一都用code标示编码)
     */
    @RequestMapping("/DicApartment")
    @ResponseBody
    public Map<String,Object> DicApartment(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String xqbh = request.getParameter("code");  //校区编号
            param.put("xqbh",xqbh);
            result.put("data",dicService.DicApartment(param));
            result.put("message","公寓字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","公寓字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 楼字典
     * code公寓编号(页面菜单获取下级菜单统一都用code标示编码)
     */
    @RequestMapping("/DicFloor")
    @ResponseBody
    public Map<String,Object> DicFloor(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String gybh = request.getParameter("code");  //公寓编号
            param.put("gybh",gybh);
            result.put("data",dicService.DicFloorAll(param));
            result.put("message","楼字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","楼字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 楼字典
     * code公寓编号(页面菜单获取下级菜单统一都用code标示编码)
     */
    @RequestMapping("/DicFloorAll")
    @ResponseBody
    public Map<String,Object> DicFloorAll(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",dicService.DicFloorAll(param));
            result.put("message","楼字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","楼字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 房间字典
     * code 楼编号(页面菜单获取下级菜单统一都用code标示编码)
     */
    @RequestMapping("/DicRoom")
    @ResponseBody
    public Map<String,Object> DicRoom(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String loubh = request.getParameter("code");  //公寓编号
            param.put("loubh",loubh);
            result.put("data",dicService.DicRoom(param));
            result.put("message","房间字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","房间字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 字典表字典查询---1级菜单
     * lx 字典类型（ 对应文件  字典.xlsx）
     */
    @RequestMapping("/DicGet")
    @ResponseBody
    public Map<String,Object> DicGet(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String lx = request.getParameter("lx");  //公寓编号
            param.put("lx",lx);
            result.put("data",dicService.DicGet(param));
            result.put("message","字典表字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","字典表字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 字典表字典查询---下（子）级菜单
     * lx 字典类型（ 对应文件  字典.xlsx）
     * id 上级菜单ID
     */
    @RequestMapping("/DicGetS")
    @ResponseBody
    public Map<String,Object> DicGetS(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String lx = request.getParameter("lx");  //公寓编号
            String id = request.getParameter("id");  //公寓编号
            param.put("lx",lx);
            param.put("id",id);
            result.put("data",dicService.DicGetS(param));
            result.put("message","字典表字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","字典表字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *年级字典
//     * xy  学院
     * zy  专业
     */
    @RequestMapping("/DicNj")
    @ResponseBody
    public Map<String,Object> DicNj(String xy,String zy){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
//            param.put("xy",xy);
            param.put("zy",zy);
            result.put("data",dicService.DicNj(param));
            result.put("message","年级字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","年级字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *班级字典
//     * xy  学院
     * zy  专业
     * nj  年级
     */
    @RequestMapping("/DicBj")
    @ResponseBody
    public Map<String,Object> DicBj(String xy,String zy,String nj){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
//            param.put("xy",xy);
            param.put("zy",zy);
            param.put("nj",nj);
            result.put("data",dicService.DicBj(param));
            result.put("message","班级字典查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","班级字典查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
}
