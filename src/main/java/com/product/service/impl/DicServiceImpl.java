package com.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.product.mapper.DicMapper;
import com.product.service.DicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DicServiceImpl implements DicService {

    @Resource
    private DicMapper dicMapper;

    @Override
    public List<Map<String, Object>> DicCampus(Map<String, Object> param) {
        return dicMapper.DicCampus(param);
    }
}
