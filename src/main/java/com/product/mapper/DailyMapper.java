package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface DailyMapper {
    /**
     * 按房间编号分组  查询条件到楼，因为展示也只能展示到楼
     */
    List<Map<String,Object>> FjbhList(Map<String,Object> param);
    /**
     *
     */
    List<Map<String,Object>> BedList(Map<String,Object> param);

}
