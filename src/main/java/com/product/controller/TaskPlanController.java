package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.DicService;
import com.product.service.TaskPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 任务计划
 */
@Controller
@RequestMapping("/taskPlan")
@CrossOrigin
public class TaskPlanController {
    @Resource
    private TaskPlanService taskPlanService;

    /**
     * 1.选择划分规则 2.根据分配规则是选到对应楼还是校区的bh
     * 3下一步，访问接口传回选中对应男/女有多少空床位
     * 4.访问接口 返回可选择的人  5.选择人，点下一步，返回页面选择男/女多少人
     * 6.判断选择人数，是否不大于空床位数，决定是否可以点击创建计划按钮
     * 7.选择开始时间和结束时间 和填写任务名
     * 创建计划
     * task_name   任务名称
     * kssj     开始时间    20190428103230
     * jssj     结束时间    20190428103230
     * hfgz     划分规则  1--按楼栋分配   2--按校区分配
     * hfbh     划分编号   选择楼就传选择的楼的编号，如果选到校区就传校区的编号
     * users    用户ID     1,2,3,4
     * http://localhost:8080/taskPlan/AddTaskPlan?task_name=taskname&kssj=20190420143021&jssj=20190428143234&hfgz=1&hfbh=02&users=1,2
     */
    @RequestMapping("/AddTaskPlan")
    @ResponseBody
    public Map<String,Object> AddTaskPlan(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        param.put("rksj",created_time);
        try{
            String task_name = request.getParameter("task_name");
            param.put("task_name",task_name);
            String kssj = request.getParameter("kssj");
            param.put("kssj",kssj);
            String jssj = request.getParameter("jssj");
            param.put("jssj",jssj);
            String hfgz = request.getParameter("hfgz");
            param.put("hfgz",hfgz);
            String hfbh = request.getParameter("hfbh");
            param.put("hfbh",hfbh);
            String users = request.getParameter("users");
            param.put("users",users);
            taskPlanService.AddTaskPlan(param);
            result.put("data",null);
            result.put("message","停用楼操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","停用楼操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 空床位数
     * hfgz  划分规则  1--按楼栋分配   2--按校区分配
     * hfbh  划分编号
     * http://localhost:8080/taskPlan/EmptyBed?hfgz=2&hfbh=02
     */
    @RequestMapping("/EmptyBed")
    @ResponseBody
    public Map<String,Object> EmptyBed(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        String hfgz = request.getParameter("hfgz");
        String hfbh = request.getParameter("hfbh");
        param.put("hfgz",hfgz);
        param.put("hfbh",hfbh);
        try{
            result.put("data",taskPlanService.EmptyBed(param));
            result.put("message","空床位查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","空床位查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 可划分选择人群---选择学生
     * 去掉类别lb 类别(默认为空)
//     * xy 学院（默认为空）
     * zy 专业（默认为空）
     * nj 年级（默认为空）
     * bj 班级（默认为空）
     *
     */
    @RequestMapping("/ChooseStu")
    @ResponseBody
    public Map<String,Object> ChooseStu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
//        String lb = request.getParameter("lb");
//        String xy = request.getParameter("xy");
        String zy = request.getParameter("zy");
        String nj = request.getParameter("nj");
        String bj = request.getParameter("bj");
        param.put("lb","");
        param.put("xy","");
        param.put("zy",zy);
        param.put("nj",nj);
        param.put("bj",bj);
        try{
            result.put("data",taskPlanService.ChooseStu(param));
            result.put("message","可划分选择人群---选择学生查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","可划分选择人群---选择学生查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }



    /**
     * 删除计划     ***可以删除未执行的任务/执行完的任务不能删除
     * rwbh  任务编号
     */
    @RequestMapping("/DelTaskPlan")
    @ResponseBody
    public Map<String,Object> DelTaskPlan(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String rwbh = request.getParameter("rwbh");
            param.put("rwbh",rwbh);
            taskPlanService.DelTaskPlan(param);
            result.put("data",null);
            result.put("message","删除计划成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","删除计划失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 任务计划列表List
     * zt  1-任务中 2-任务完成  3--任务失败
     * pageSize
     * pageNum
     */
    @RequestMapping("/taskBaseList")
    @ResponseBody
    public Map<String,Object> taskBaseList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            String pageNumS =request.getParameter("pageNum");
            String pageSizeS=request.getParameter("pageSize");
            int pageNum =1;
            int pageSize =10;
            if(pageNumS!=null){
                pageNum = Integer.parseInt(pageNumS);
            }
            if(pageSizeS!=null){
                pageSize= Integer.parseInt(pageSizeS);
            }
            String zt = request.getParameter("zt");
            if(zt==null){
                zt= "1";
            }
            param.put("zt",zt);
            list = taskPlanService.taskBaseList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","任务计划列表List查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","任务计划列表List查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }

        return result;
    }
    /**
     * 任务对应学生信息List
     * rwbh   任务编号
     * pageSize
     * pageNum
     */
    @RequestMapping("/taskDeStu")
    @ResponseBody
    public Map<String,Object> taskDeStu(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            String rwbh = request.getParameter("rwbh");
            param.put("rwbh",rwbh);
            list = taskPlanService.taskDeStu(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","任务计划列表List查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","任务计划列表List查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }

        return result;
    }
}
