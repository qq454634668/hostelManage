package com.product.service;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    int existUser(Map<String, Object> param);

    /**
     * 用户信息
     */
    List<Map<String,Object>> userInfo(Map<String,Object> param);
    /**
     * 菜单信息
     */
    List<Map<String,Object>> menuInfo(Map<String,Object> param);
    /**
     * 用户信息
     */
    List<Map<String,Object>> userInfoId(Map<String,Object> param);
    /**
     *获取userId
     */
    List<Map<String,Object>> getUserInfoId(Map<String,Object> param);
    /**
     * 添加token
     */
    void insertToken(Map<String,Object> param);


}
