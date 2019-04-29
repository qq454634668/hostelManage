package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface TaskPlanMapper {
    /**
     * 插入任务计划基础表
     **/
    int InsTaskBase(Map<String,Object> param);
    /**
     * 插入任务计划详情表
     **/
    int InsTaskDet(Map<String,Object> param);
    /**
     * 更新学生分配状态成分配中
     **/
    int UpStuFpzt(Map<String,Object> param);

    /**
     *男/女空床位计算
     */
    List<Map<String,Object>> EmptyBed(Map<String,Object> param);
    /**
     *可划分选择人群---选择学生
     */
    List<Map<String,Object>> ChooseStu(Map<String,Object> param);
    /**
     *更新学生分配状态成未分配
     */
    int UpStuFpztW(Map<String,Object> param);
    /**
     *删除详情任务表
     */
    int DelTaskDe(Map<String,Object> param);
    /**
     *删除基础任务表
     */
    int DelTaskBa(Map<String,Object> param);

    /**
     * 任务表
     */
    List<Map<String,Object>> taskBaseList(Map<String,Object> param);
    /**
     * 任务对应学生信息
     */
    List<Map<String,Object>> taskDeStu(Map<String,Object> param);
}
