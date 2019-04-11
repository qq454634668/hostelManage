package com.product.service;

import java.util.List;
import java.util.Map;

public interface PurviewService {
    /**
     * 增加菜单
     */
    void AddMenu(Map<String,Object> param);

    /**
     * 修改菜单
     */
    void EditMenu(Map<String,Object> param);

    /**
     * 查询菜单
     */
    List<Map<String,Object>> QueryMenu(Map<String,Object> param);

    /**
     * 删除菜单
     */
    void DeleteMenu(Map<String,Object> param);

    /**
     *创建角色
     */
    void AddRole(Map<String,Object> param);
    /**
     *修改角色  --修改角色名
     */
    void EditRoleName(Map<String,Object> param);
    /**
     *修改角色  --修改角色菜单
     */
    void EditRoleMenu(Map<String,Object> param);
    /**
     * 删除角色
     */
    void DeleteRole(Map<String,Object> param);
    /**
     * 角色是否存在关联用户
     */
    int ExistRoleUser(Map<String,Object> param);
    /**
     * 添加用户
     */
    void AddUser(Map<String,Object> param);
}
