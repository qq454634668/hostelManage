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

    /**
     * 修改角色  --修改角色名
     */
    int EditRoleName(Map<String,Object> param);
    /**
     * 删除角色对应菜单
     */
    int DeleteRoleMenu(Map<String,Object> param);
    /**
     * 删除角色
     */
    int DeleteRoleInfo(Map<String,Object> param);
    /**
     * 角色是否存在关联用户
     */
    int ExistRoleUser(Map<String,Object> param);
    /**
     * 添加用户
     */
    int AddUser(Map<String,Object> param);
    /**
     * 用户授权
     */
    int AddUserRole(Map<String,Object> param);
    /**
     * 删除用户
     */
    int DeleteUser(Map<String,Object> param);
    /**
     *删除用户权限关联表
     */
    int DeleteUserRole(Map<String,Object> param);
    /**
     *修改用户
     */
    int EditUser(Map<String,Object> param);
    /**
     *用户列表
     */
    List<Map<String, Object>> QueryUserList(Map<String,Object> param);


}
