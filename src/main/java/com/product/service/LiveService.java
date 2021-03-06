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
    /**
     *公寓区列表
     */
    List<Map<String, Object>> QueryApartmentList(Map<String,Object> param,int pageNum,int pageSize);
    /**
     * 新增公寓区-----新增campus_info数据
     */
    void AddApartment(Map<String,Object> param);
    /**
     * 修改公寓区
     */
    void EditApartment(Map<String,Object> param);
    /**
     * 删除公寓区
     */
    void DeleteApartment(Map<String,Object> param);
    /**
     * 是否存在楼
     */
    int ExistFloor(Map<String,Object> param);
    /**
     *楼列表
     */
    List<Map<String, Object>> QueryFloorList(Map<String,Object> param,int pageNum,int pageSize);
    /**
     * 新增楼区
     */
    void AddFloor(Map<String,Object> param);

    /**
     * 修改公寓区
     */
    void EditFloor(Map<String,Object> param);
    /**
     * 删除楼栋
     */
    void DelFloor(Map<String,Object> param);

    /**
     * 是否存在床
     */
    int ExistBedZtLou(Map<String,Object> param);
    /**
     *房间列表
     */
    List<Map<String, Object>> QueryRoomList(Map<String,Object> param,int pageNum,int pageSize);
    /**
     * 新增房间
     */
    void AddRoom(Map<String,Object> param);
    /**
     * 修改房间
     */
    void EditRoom(Map<String,Object> param);
    /**
     * 该楼该房间下是否有入住
     */
    int ExistRoomRz(Map<String,Object> param);
    /**
     * 判断是否存在重复房间
     */
    int repeatRoom(Map<String,Object> param);
    /**
     * 删除房间
     */
    void DelRoom(Map<String,Object> param);
    /**
     * 停用房间/启用房间
     */
    void StopRoom(Map<String,Object> param);
    /**
     * 床位列表
     */
    List<Map<String, Object>> QueryBedList(Map<String,Object> param,int pageNum,int pageSize);
    /**
     * 停用床位/启用床位
     */
    void StopBed(Map<String,Object> param);
}
