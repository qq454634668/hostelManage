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
     *点击床位入住/换宿
     * xh  学号
     * cwbh 床位编号
     *020301101011   191116
     */
    @RequestMapping("/MoveInto")
    @ResponseBody
    public Map<String,Object> MoveInto(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try {
            String xh = request.getParameter("xh");
            String cwbh = request.getParameter("cwbh");
            param.put("xh",xh);
            param.put("cwbh",cwbh);
            dailyService.MoveInto(param);
            result.put("data",null);
            result.put("message","床位入住/换宿操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","床位入住/换宿操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }

        return result;
    }
    /**
     *退宿
     *cwbh 床位编号
     */
    @RequestMapping("/QuitSs")
    @ResponseBody
    public Map<String,Object> QuitSs(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try {
            String cwbh = request.getParameter("cwbh");
            param.put("cwbh",cwbh);
            dailyService.QuitSs(param);
            result.put("data",null);
            result.put("message","退宿操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","退宿操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }

        return result;
    }
    /**--------------------------------入住管理 end----------------------------------------*/

    /**--------------------------------宿舍管理 start----------------------------------------*/
    //入住流程----先根据楼展示床位列表----点击床位进行申请--生成申请记录
    /**
     * 入住/换宿/退宿申请记录List
     * zxzt   ---1申请中  ---2申请成功   ---3申请失败
     * sqlx   ---1入住    --2换宿        ---3退宿
     */
    @RequestMapping("/applyForList")
    @ResponseBody
    public Map<String,Object> applyForList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            String zxzt = request.getParameter("zxzt");
            String sqlx = request.getParameter("sqlx");
            param.put("zxzt",zxzt);
            param.put("sqlx",sqlx);
            list = dailyService.applyForList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","入住/换宿/退宿申请记录List操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","入住/换宿/退宿申请记录List操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }

        return result;
    }

    /**
     * 审批申请-----同意/不同意申请，同意自动更换或者入住
     * id
     * sqrxh 申请人学号
     * ycwbh原床位编号
     * sqcwbh申请床位编号
     * sqlx  申请类型
     * sqlx  申请类型
     * zxzt  申请状态成功---2/申请状态失败---3
     * zxjgyy  执行结果原因
     */
    @RequestMapping("/verifyAsk")
    @ResponseBody
    public Map<String,Object> verifyAsk(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        param.put("rksj",created_time);
        try {
            String id = request.getParameter("id");
            String sqrxh = request.getParameter("sqrxh");
            String ycwbh = request.getParameter("ycwbh");
            String sqcwbh = request.getParameter("sqcwbh");
            String sqlx = request.getParameter("sqlx");
            String zxzt = request.getParameter("zxzt");
            String zxjgyy = request.getParameter("zxjgyy");
            dailyService.verifyAsk(sqrxh,ycwbh,sqcwbh,sqlx,zxzt,zxjgyy,id);
            result.put("data",null);
            result.put("message","退宿操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","退宿操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }

        return result;
    }
    /**
     * 申请(入住/换宿/退宿)---生成申请记录
     * sqrxm 申请人姓名
     * sqrxh 申请人学号
     * sqlx  申请类型
     * sqyy  申请原因
     * zxjgyy  执行结果原因
     * ycwbh  原床位编号
     * sqcwbh  申请床位编号
     */
    @RequestMapping("/applyForAsk")
    @ResponseBody
    public Map<String,Object> applyForAsk(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        param.put("rksj",created_time);
        try {
            String sqrxm = request.getParameter("sqrxm");
            param.put("sqrxm",sqrxm);
            String sqrxh = request.getParameter("sqrxh");
            param.put("sqrxh",sqrxh);
            String sqlx = request.getParameter("sqlx");
            param.put("sqlx",sqlx);
            String sqyy = request.getParameter("sqyy");
            param.put("sqyy",sqyy);
            String zxjgyy = request.getParameter("zxjgyy");
            param.put("zxjgyy",zxjgyy);
            String ycwbh = request.getParameter("ycwbh");
            param.put("ycwbh",ycwbh);
            String sqcwbh = request.getParameter("sqcwbh");
            param.put("sqcwbh",sqcwbh);
            param.put("zxzt","1");//执行状态 申请中
            dailyService.applyForAsk(param);
            result.put("data",null);
            result.put("message","申请操作成功");
            result.put("code","200");
        }catch (Exception e) {
            result.put("message", "申请操作失败");
            result.put("code", "500");
            result.put("data", e.getMessage());
        }
        return result;
    }
    /**--------------------------------宿舍管理 end----------------------------------------*/
}
