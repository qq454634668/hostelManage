package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface DicMapper {
    /**
     * 校区字典
     **/
    List<Map<String,Object>> DicCampus(Map<String,Object> param);
    /**
     * 公寓字典
     **/
    List<Map<String,Object>> DicApartment(Map<String,Object> param);
    /**
     * 楼字典
     **/
    List<Map<String,Object>> DicFloor(Map<String,Object> param);
    /**
     * 房间字典
     **/
    List<Map<String,Object>> DicRoom(Map<String,Object> param);
    /**
     * 字典查询
     **/
    List<Map<String,Object>> DicGet(Map<String,Object> param);
    /**
     * 字典子查询
     **/
    List<Map<String,Object>> DicGetS(Map<String,Object> param);
}
