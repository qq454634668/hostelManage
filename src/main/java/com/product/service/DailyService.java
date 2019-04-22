package com.product.service;

import java.util.List;
import java.util.Map;

public interface DailyService {
    /**
     *床位按楼的一个根据fjbh分组的list
     */
    List<Map<String, Object>> BedListMap(Map<String,Object> param);
    /**
     *学生list
     */
    List<Map<String, Object>> StuList(Map<String,Object> param,int pageNum,int pageSize);
    /**
     * 入住/换宿
     */
    void MoveInto(Map<String,Object> param);
}
