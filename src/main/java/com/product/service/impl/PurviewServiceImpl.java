package com.product.service.impl;

import com.product.mapper.PurviewMapper;
import com.product.service.PurviewService;

import javax.annotation.Resource;
import java.util.Map;

public class PurviewServiceImpl implements PurviewService {

    @Resource
    private PurviewMapper purviewMapper;

    @Override
    public void AddMenu(Map<String, Object> param) {
        purviewMapper.AddMenu(param);
    }
}
