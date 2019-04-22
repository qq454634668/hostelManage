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

}
