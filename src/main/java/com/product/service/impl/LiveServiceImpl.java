package com.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.product.mapper.LiveMapper;
import com.product.service.LiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LiveServiceImpl implements LiveService {

    @Resource
    private LiveMapper liveMapper;


}
