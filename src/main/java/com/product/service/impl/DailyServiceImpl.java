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


    @Override
    public List<Map<String, Object>> BedListMap(Map<String, Object> param) {
        List<Map<String,Object>> list = dailyMapper.FjbhList(param);
        List<Map<String,Object>> result = new ArrayList<>();
        System.out.println(list.size());
        list.forEach(bedMap->{
            Map<String,Object> map = new HashMap<>();
            Object fjbh = bedMap.get("fjbh");
            map.put("fjbh",fjbh);
            param.put("fjbh",fjbh);
            map.put("fjList",dailyMapper.BedList(param));
            result.add(map);

        });
        System.out.println("查询结束");
        return result;
    }

    @Override
    public List<Map<String, Object>> StuList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return dailyMapper.StuList(param);
    }

    @Override
    @Transactional
    public void MoveInto(Map<String, Object> param) {
        int flag = dailyMapper.MoveInto(param);
        if(flag <= 0){
            throw new RuntimeException("入住失败");
        }else{
            int flag2 = dailyMapper.MoveInto2(param);
            if(flag2 <= 0){
                throw new RuntimeException("入住失败");
            }
        }
    }

    @Override
    @Transactional
    public void QuitSs(Map<String, Object> param) {
        int flag = dailyMapper.QuitSs1(param);
        if(flag <= 0){
            throw new RuntimeException("退宿失败");
        }else{
            int flag2 = dailyMapper.QuitSs2(param);
            if(flag2 <= 0){
                throw new RuntimeException("退宿失败");
            }
        }
    }
}
