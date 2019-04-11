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
}
