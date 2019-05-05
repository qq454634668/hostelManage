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
    /**
     * 用户授权
     */
    void AddUserRole(Map<String,Object> param);
    /**
     * 用户删除
     */
    void DeleteUser(Map<String,Object> param);
    /**
     *修改用户
     */
    void EditUser(Map<String,Object> param);
    /**
     * 修改用户授权
     */
    void EditUserRole(Map<String,Object> param);
    /**
     *用户列表
     */
    List<Map<String, Object>> QueryUserList(Map<String,Object> param,int pageNum,int pageSize);
    /**
     *可选择菜单
     */
    List<Map<String, Object>> SelectMenu(Map<String,Object> param);

    /**
     * 权限列表
     */
    List<Map<String, Object>> RoleList(Map<String,Object> param);
}
