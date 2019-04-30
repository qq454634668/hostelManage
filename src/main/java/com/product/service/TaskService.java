package com.product.service;


import com.product.pojo.BedInfo;
import com.product.pojo.TaskBaseinfo;
import com.product.pojo.TaskDetailed;
import com.product.pojo.UserStudent;

import java.util.List;
import java.util.Map;

public interface TaskService {

    //可以执行的任务计划 zt='1' 有效时间在kssj和jssj 范围内
    public List<TaskBaseinfo> getValidTaskBaseinfoList();

    //查询任务计划中的 zt=‘1’ rwbh=rwbh
    public List<TaskDetailed> getValidTaskDetailedMaleList(String rwbh);
    //查询任务计划中的 zt=‘1’ rwbh=rwbh
    public List<TaskDetailed> getValidTaskDetailedFeMaleList(String rwbh);
    //任务计划,自动分配床位
    public void rwfp();

    //查询xb=1的空闲床位
    public List<BedInfo> getValidBedInfoMaleList(String lx,String bh);
    //查询xb=2的空闲床位
    public List<BedInfo> getValidBedInfoFeMaleList(String lx,String bh);

    public void updateUserSutdent(String fpzt,String cwbh,String zszt,String xh);
    public void updateTaskDetailed(String taskDetailedZt,long taskDetailedId);
    public void updateTaskBaseInfo(String zt,String bh);
    public void updateBedInfo(String zt,String bh);
    public void updateBedInfo(String zt,List<BedInfo> bedInfos);
    public void updateTaskDetailed(String taskDetailedZt,List<TaskDetailed> taskDetaileds);
    public void updateUserSutdent(String fpzt,String zszt,List<BedInfo> bedInfos ,List<TaskDetailed> taskDetaileds);


}
