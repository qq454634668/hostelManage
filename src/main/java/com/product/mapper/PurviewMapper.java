package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface PurviewMapper {
    /**
     * 增加菜单
     */
    int AddMenu(Map<String,Object> param);

    /**
     * 修改菜单
     */
    int EditMenu(Map<String,Object> param);

    /**
     * 根据parent_id查询
     */
    List<Map<String, Object>> QueryMenu(Map<String,Object> param);

    /**
     * 删除菜单
     */
    int DeleteMenu(Map<String,Object> param);

    /**
     * 创建角色-----新增role_info数据
     */
    int AddRoleInfo(Map<String,Object> param);
    /**
     * 创建角色-----新增role_menu菜单数据
     */
    int AddRoleMenu(Map<String,Object> param);


}
