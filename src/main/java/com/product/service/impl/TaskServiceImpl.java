package com.product.service.impl;


import com.product.config.TimeTask;
import com.product.mapper.TaskMapper;
import com.product.pojo.BedInfo;
import com.product.pojo.TaskBaseinfo;
import com.product.pojo.TaskDetailed;
import com.product.pojo.UserStudent;
import com.product.service.TaskService;
import com.product.util.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;

    private static Logger logger= LoggerFactory.getLogger(TaskServiceImpl.class);


    @Override
    public List<TaskBaseinfo> getValidTaskBaseinfoList() {
        Map<String, Object> param = new HashMap<>();

        param.put("task_zt",1);
        param.put("task_now", DateTimeUtils.timeToString(new Date(),"yyyyMMddHHmmss"));

        return taskMapper.getTaskBaseinfoList(param);
    }

    @Override
    public List<TaskDetailed> getValidTaskDetailedMaleList(String rwbh) {
        Map<String, Object> param = new HashMap<>();

        param.put("task_student_zt",1);
        param.put("task_rwbh", rwbh);
        param.put("student_xb",1);

        return taskMapper.getTaskDetailedList(param);
    }
    @Override
    public List<TaskDetailed> getValidTaskDetailedFeMaleList(String rwbh) {
        Map<String, Object> param = new HashMap<>();

        param.put("task_student_zt",1);
        param.put("task_rwbh", rwbh);
        param.put("student_xb",2);

        return taskMapper.getTaskDetailedList(param);
    }



    /**
     *  定时任务，用于自动分配宿舍
     *  1.找任务 读取task_baseinfo（状态任务中）
     *  2.找人 读取task_detailed 关联 user_student表 根据性别和班级排序，分出男女
     *  3.找床 bed_info 根据床位编号排序，条件是zt（闲置中），louzt（男女），根据task_baseinfo中的划分规则xqbh,loubh
     *  4.设置user_sutdent   bed_info task_baseinfo task_detailed
     */
    @Override
    public void rwfp() {
        List<TaskBaseinfo> validTaskBaseinfoList = this.getValidTaskBaseinfoList();
        for (int i = 0;i<validTaskBaseinfoList.size();i++){
            TaskBaseinfo taskBaseinfo = validTaskBaseinfoList.get(i);
            logger.warn(taskBaseinfo.getTaskName());
            List<TaskDetailed> taskDetailedMaleList = this.getValidTaskDetailedMaleList(taskBaseinfo.getRwbh());
            List<BedInfo> bedInfoMaleList = this.getValidBedInfoMaleList(taskBaseinfo.getHfgz(), taskBaseinfo.getHfbh());
            List<TaskDetailed> taskDetailedFeMaleList = this.getValidTaskDetailedFeMaleList(taskBaseinfo.getRwbh());
            List<BedInfo> bedInfoFeMaleList = this.getValidBedInfoFeMaleList(taskBaseinfo.getHfgz(), taskBaseinfo.getHfbh());
            if(taskDetailedMaleList.size()>0) {
                if (taskDetailedMaleList.size() <= bedInfoMaleList.size()) {
                    this.updateUserSutdent("3", "2", bedInfoMaleList, taskDetailedMaleList);
                    this.updateBedInfo("2", bedInfoMaleList);
                    this.updateTaskDetailed("2", taskDetailedMaleList);
                    this.updateTaskBaseInfo("2",taskBaseinfo.getRwbh());
                }else{
                    this.updateTaskDetailed("3",taskDetailedMaleList);
                    this.updateUserSutdent("1","1",null,taskDetailedMaleList);
                    this.updateTaskBaseInfo("3",taskBaseinfo.getRwbh());
                }
            }
            if(taskDetailedFeMaleList.size()>0){
                if(taskDetailedFeMaleList.size()<=bedInfoFeMaleList.size()){
                    this.updateUserSutdent("3","2",bedInfoFeMaleList,taskDetailedFeMaleList);
                    this.updateBedInfo("2",bedInfoFeMaleList);
                    this.updateTaskDetailed("2",taskDetailedFeMaleList);
                    this.updateTaskBaseInfo("2",taskBaseinfo.getRwbh());
                }else{
                    //设置任务状态失败
                    this.updateTaskDetailed("3",taskDetailedFeMaleList);
                    this.updateUserSutdent("1","1",null,taskDetailedFeMaleList);
                    this.updateTaskBaseInfo("3",taskBaseinfo.getRwbh());
                }
            }
            if(taskDetailedFeMaleList.size()<=0&&taskDetailedMaleList.size()<=0){
                this.updateTaskBaseInfo("3",taskBaseinfo.getRwbh());
            }
        }
    }

    @Override
    public List<BedInfo> getValidBedInfoMaleList(String lx,String bh) {
        Map<String, Object> param = new HashMap<>();

        param.put("bed_zt",1);
        param.put("bed_bh", bh);
        param.put("bed_lx", lx);
        param.put("bed_louzt",1);

        return taskMapper.getBedInfoList(param);
    }

    @Override
    public List<BedInfo> getValidBedInfoFeMaleList(String lx,String bh) {
        Map<String, Object> param = new HashMap<>();

        param.put("bed_zt",1);
        param.put("bed_bh", bh);
        param.put("bed_lx", lx);
        param.put("bed_louzt",2);
        return taskMapper.getBedInfoList(param);
    }



    @Override
    public void updateUserSutdent(String fpzt,String cwbh,String zszt,String xh) {
        Map<String, Object> param = new HashMap<>();
        param.put("user_student_fpzt",fpzt);
        param.put("user_student_cwbh",cwbh);
        param.put("user_student_zszt",zszt);
        param.put("user_student_xh",xh);


         taskMapper.updateUserSutdent(param);
    }

    @Override
    public void updateTaskDetailed(String taskDetailedZt,long taskDetailedId) {
        Map<String, Object> param = new HashMap<>();
        param.put("task_detailed_zt",taskDetailedZt);
        param.put("task_detailed_id",taskDetailedId);


        taskMapper.updateTaskDetailed(param);
    }

    @Override
    public void updateTaskBaseInfo(String zt,String bh) {
        Map<String, Object> param = new HashMap<>();
        param.put("task_zt",zt);
        param.put("task_bh",bh);


        taskMapper.updateTaskBaseInfo(param);
    }

    @Override
    public void updateBedInfo(String zt, List<BedInfo> bedInfos) {
        Map<String, Object> param = new HashMap<>();
        param.put("bed_zt",zt);
        param.put("list",bedInfos);

        taskMapper.updateBedInfo(param);
    }

    @Override
    public void updateTaskDetailed(String taskDetailedZt, List<TaskDetailed> taskDetaileds) {
        Map<String, Object> param = new HashMap<>();
        param.put("task_detailed_zt",taskDetailedZt);
        param.put("list",taskDetaileds);

        taskMapper.updateTaskDetailed(param);
    }

    @Override
    public void updateUserSutdent(String fpzt, String zszt,List<BedInfo> bedInfos ,List<TaskDetailed> taskDetaileds) {
        List<UserStudent> userStudents = new LinkedList<>();
        if(null==bedInfos||0==bedInfos.size()){//zzszt 1 未住宿 fpzt 1 未分配
            for (int i=0;i<taskDetaileds.size();i++){
                TaskDetailed detailed = taskDetaileds.get(i);
                UserStudent student = detailed.getUserStudent();
                BedInfo bedInfo = bedInfos.get(i);
                student.setCwbh(bedInfo.getBh());
                userStudents.add(student);
            }
        }else{
            for (int i=0;i<taskDetaileds.size();i++){
                TaskDetailed detailed = taskDetaileds.get(i);
                UserStudent student = detailed.getUserStudent();
                student.setCwbh(null);
                userStudents.add(student);
            }
        }

        Map<String, Object> param = new HashMap<>();
        param.put("user_student_fpzt",fpzt);
        param.put("user_student_zszt",zszt);
        param.put("list",userStudents);


        taskMapper.updateUserSutdent(param);
    }

    @Override
    public void updateBedInfo(String zt,String bh) {
        Map<String, Object> param = new HashMap<>();
        param.put("bed_zt",zt);
        param.put("bed_bh",bh);


        taskMapper.updateBedInfo(param);
    }

}
