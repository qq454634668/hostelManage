package com.product.service;

import java.util.List;
import java.util.Map;

public interface LiveService {
    /**
     * 新增校区-----新增campus_info数据
     */
    void AddCampus(Map<String,Object> param);
    /**
     * 修改校区
     */
    void EditCampus(Map<String,Object> param);
    /**
     * 删除校区
     */
    void DeleteCampus(Map<String,Object> param);
    /**
     * 是否存在公寓
     */
    int ExistApartment(Map<String,Object> param);
    /**
     *校区列表
     */
    List<Map<String, Object>> QueryCampusList(Map<String,Object> param,int pageNum,int pageSize);
}
