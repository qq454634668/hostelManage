package com.product.service;


import java.util.List;
import java.util.Map;

public interface UserService {
    int existUser(Map<String, Object> param);

    List<Map<String,Object>> login(Map<String,Object> param);

}
