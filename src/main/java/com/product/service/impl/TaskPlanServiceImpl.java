package com.product.service.impl;


import com.product.mapper.TaskPlanMapper;
import com.product.service.TaskPlanService;
import org.springframework.stereotype.Service;

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
    public void AddTaskPlan(Map<String, Object> param) {
        String users = (String) param.get("users");
        String[] usersString = users.split(",");
        List userList =new ArrayList();
        for(int i=0;i<usersString.length;i++){
            Map<String,Object> lsMap = new HashMap<>();
            lsMap.put("user_student_id",usersString[i]);
            userList.add(lsMap);
        }
        param.put("userList",userList);
    }
}
