package com.product.service;

import java.util.List;
import java.util.Map;

public interface TaskPlanService {
    /**
     * 创建任务计划
     */
    void AddTaskPlan(Map<String,Object> param);

    /**
     *男/女空床位计算
     */
    List<Map<String,Object>> EmptyBed(Map<String,Object> param);
    /**
     *可划分选择人群---选择学生
     */
    List<Map<String,Object>> ChooseStu(Map<String,Object> param);
}
