package com.product.mapper;


import com.product.pojo.BedInfo;
import com.product.pojo.TaskBaseinfo;
import com.product.pojo.TaskDetailed;

import java.util.List;
import java.util.Map;

public interface TaskMapper {


    public List<TaskBaseinfo> getTaskBaseinfoList(Map<String, Object> param);
    public List<TaskDetailed> getTaskDetailedList(Map<String, Object> param);
    public List<BedInfo> getBedInfoList(Map<String, Object> param);

    public void updateUserSutdent(Map<String, Object> param);
    public void updateTaskDetailed(Map<String, Object> param);
    public void updateTaskBaseInfo(Map<String, Object> param);
    public void updateBedInfo(Map<String, Object> param);
}