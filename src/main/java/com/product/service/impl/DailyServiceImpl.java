package com.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.product.mapper.DailyMapper;
import com.product.service.DailyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DailyServiceImpl implements DailyService {

    @Resource
    private DailyMapper dailyMapper;


}
