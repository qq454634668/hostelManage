package com.product.service.impl;

import com.product.mapper.PurviewMapper;
import com.product.service.PurviewService;

import javax.annotation.Resource;

public class PurviewServiceImpl implements PurviewService {

    @Resource
    private PurviewMapper userMapper;
}
