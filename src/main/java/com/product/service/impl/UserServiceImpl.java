package com.product.service.impl;

import com.product.mapper.UserMapper;
import com.product.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int existUser(Map<String, Object> param) {
        return userMapper.existUser(param);
    }


}
