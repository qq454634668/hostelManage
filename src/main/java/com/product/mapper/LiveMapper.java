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
}
