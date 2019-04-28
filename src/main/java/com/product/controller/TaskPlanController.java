package com.product.controller;

import com.product.service.DicService;
import com.product.service.TaskPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 任务计划
 */
@Controller
@RequestMapping("/taskPlan")
public class TaskPlanController {
    @Resource
    private TaskPlanService taskPlanService;

    /**
     * 创建计划
     * task_name   任务名称
     * kssj     开始时间    20190428103230
     * jssj     结束时间    20190428103230
     * hfgz     划分规则  1--按楼栋分配   2--按校区分配
     * hfbh     划分编号   选择楼就传选择的楼的编号，如果选到校区就传校区的编号
     * users    用户ID     1,2,3,4
     */
    @RequestMapping("/AddTaskPlan")
    @ResponseBody
    public Map<String,Object> AddTaskPlan(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("rksj",created_time);
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
}
