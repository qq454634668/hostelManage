package com.product.mapper;

import java.util.List;
import java.util.Map;

public interface PurviewMapper {
    /**
     * 增加菜单
     */
    void AddMenu(Map<String,Object> param);

    /**
     * 修改菜单
     */
    void EditMenu(Map<String,Object> param);

    /**
     * 根据parent_id查询
     */
    List<Map<String, Object>> QueryMenu(Map<String,Object> param);
}
