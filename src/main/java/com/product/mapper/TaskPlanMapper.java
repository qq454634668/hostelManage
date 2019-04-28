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
}
