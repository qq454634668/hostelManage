package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface LiveMapper {
    /**
     * 新增校区-----新增campus_info数据
     */
    int AddCampus(Map<String,Object> param);
    /**
     * update方法，只补充增加校区的bh
     */
    int EditCampusBh(Map<String,Object> param);
    /**
     * 修改校区  --根据ID修改name名
     */
    int EditCampus(Map<String,Object> param);

    /**
     * 删除校区
     */
    int DeleteCampus(Map<String,Object> param);

    /**
     * 校区下是否存在公寓---是否存在公寓
     */
    int ExistApartment(Map<String,Object> param);
    /**
     *校区列表
     */
    List<Map<String, Object>> QueryCampusList(Map<String,Object> param);
    /**
     *公寓区列表
     */
    List<Map<String, Object>> QueryApartmentList(Map<String,Object> param);
    /**
     *公寓添加方法1（只添加了name，xqbh,rksj，还有方法2，通过处理插入计算后的编号）
     */
    int AddApartment1(Map<String,Object> param);
    /**
     *公寓添加方法2（通过返回ID，插入处理好的bh和gybh字段）
     */
    int AddApartment2(Map<String,Object> param);
    /**
     * 修改公寓区  --根据ID修改name名
     */
    int EditApartment(Map<String,Object> param);
    /**
     * 删除校区
     */
    int DeleteApartment(Map<String,Object> param);
    /**
     * 是否存在楼
     */
    int ExistFloor(Map<String,Object> param);
    /**
     * 楼列表
     */
    List<Map<String, Object>> QueryFloorList(Map<String,Object> param);
    /**
     * 新增楼1  增加基本信息 name,louzt,xqbh,gybh
     */
    int AddFloor1(Map<String,Object> param);
    /**
     * 新增楼2  通过计算得到楼编号
     */
    int AddFloor2(Map<String,Object> param);
    /**
     * 修改楼 通过ID修改name
     */
    int EditFloor(Map<String,Object> param);
    /**
     * 删除楼栋
     */
    int DelFloor(Map<String,Object> param);

}
