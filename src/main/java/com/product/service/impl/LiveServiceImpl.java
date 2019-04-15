package com.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.product.mapper.LiveMapper;
import com.product.service.LiveService;
import com.product.util.CodeMakeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LiveServiceImpl implements LiveService {

    @Resource
    private LiveMapper liveMapper;


    @Override
    @Transactional
    public void AddCampus(Map<String, Object> param) {
        int flag = liveMapper.AddCampus(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }else{
            String id =  String.valueOf(param.get("id"));
            String bh = CodeMakeUtils.decade(id);
            param.put("id",id);
            param.put("bh",bh);
            int flag2 = liveMapper.EditCampusBh(param);
            if(flag2 <= 0){
                throw new RuntimeException("修改失败");
            }
        }
    }


    @Override
    @Transactional
    public void EditCampus(Map<String, Object> param) {
        int flag = liveMapper.EditCampus(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    @Transactional
    public void DeleteCampus(Map<String, Object> param) {
        int flag = liveMapper.DeleteCampus(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public int ExistApartment(Map<String, Object> param) {
        return liveMapper.ExistApartment(param);
    }

    @Override
    public List<Map<String, Object>> QueryCampusList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return liveMapper.QueryCampusList(param);
    }
}
