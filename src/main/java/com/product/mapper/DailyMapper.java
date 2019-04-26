package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface DailyMapper {
    /**
     * 按房间编号分组  查询条件到楼，因为展示也只能展示到楼
     */
    List<Map<String,Object>> FjbhList(Map<String,Object> param);
    /**
     *根据房间号和楼号  查出该房间的床位list
     */
    List<Map<String,Object>> BedList(Map<String,Object> param);
    /**
     *学生list
     */
    List<Map<String,Object>> StuList(Map<String,Object> param);

    /**
     * 入住/换宿   更改用户床位信息
     */
    int MoveInto(Map<String,Object> param);
    /**
     * 入住/换宿2  更改床位住宿信息
     */
    int MoveInto2(Map<String,Object> param);

    /**
     * 退宿
     * *
     */
    int QuitSs1(Map<String,Object> param);
    int QuitSs2(Map<String,Object> param);

    /**
     *更改床的状态
     */
    int UpdateBed(Map<String,Object> param);
    /**
     *更改学生入住状态
     */
    int UpdateStudent(Map<String,Object> param);

    /**
     * 生成申请记录
     */
    int applyForAsk(Map<String,Object> param);

    /**
     * 审批申请
     */
    int updateApply(Map<String,Object> param);

    /**
     * 申请列表
     */
    List<Map<String,Object>> applyForList(Map<String,Object> param);

}
