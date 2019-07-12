package com.product.service.impl;


import com.github.pagehelper.PageHelper;
import com.product.mapper.TaskPlanMapper;
import com.product.service.TaskPlanService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskPlanServiceImpl implements TaskPlanService {

    @Resource
    private TaskPlanMapper taskPlanMapper;

    @Override
    @Transactional
    public void AddTaskPlan(Map<String, Object> param) {
        //rwbh  任务编号创建
        int x=(int)(Math.random()*100000000);
        String rwbh = "A"+x;
        param.put("rwbh",rwbh);
        //插入任务基础表
        int flag = taskPlanMapper.InsTaskBase(param);
//        int flag = 1;
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }else{
            //插入任务详情人员名单表
            String users = (String) param.get("users");
            String Stringusers = StringUtils.strip(users.toString(),"[]");
            String[] usersString = Stringusers.split(",");
            param.put("users",usersString);
            List userList =new ArrayList();
            for(int i=0;i<usersString.length;i++){
                Map<String,Object> lsMap = new HashMap<>();
                lsMap.put("user_student_id",usersString[i]);
                userList.add(lsMap);
            }
            param.put("userList",userList);
            flag =  taskPlanMapper.InsTaskDet(param);
            if(flag <= 0){
                throw new RuntimeException("添加失败");
            }else{
                taskPlanMapper.UpStuFpzt(param);
            }

        }

    }

    @Override
    public List<Map<String, Object>> EmptyBed(Map<String, Object> param) {
        return taskPlanMapper.EmptyBed(param);
    }

    @Override
    public List<Map<String, Object>> ChooseStu(Map<String, Object> param) {
        return taskPlanMapper.ChooseStu(param);
    }

    @Override
    @Transactional
    public void DelTaskPlan(Map<String, Object> param) {
        //更新学生任务状态为未分配
        taskPlanMapper.UpStuFpztW(param);
        //删除基础任务表
        taskPlanMapper.DelTaskBa(param);
        //删除详情任务表
        taskPlanMapper.DelTaskDe(param);
    }

    @Override
    public List<Map<String, Object>> taskBaseList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return taskPlanMapper.taskBaseList(param);
    }

    @Override
    public List<Map<String, Object>> taskDeStu(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return taskPlanMapper.taskDeStu(param);
    }
}
