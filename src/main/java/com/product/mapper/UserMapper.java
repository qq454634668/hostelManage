package com.product.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int existUser(Map<String, Object> param);
    List<Map<String, Object>> UserInfo(Map<String, Object> param);

    /**
     *主菜单  parent_id =0
     */
    List<Map<String, Object>> MainMenu(Map<String, Object> param);

    /**
     *子菜单  parent_id =0
     */
    List<Map<String, Object>> UnderMenu(Map<String, Object> param);

}
