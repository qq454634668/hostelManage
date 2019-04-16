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

    @Override
    public List<Map<String, Object>> QueryApartmentList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return liveMapper.QueryApartmentList(param);
    }

    @Override
    @Transactional
    public void AddApartment(Map<String, Object> param) {
        int flag = liveMapper.AddApartment1(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }else{
            String xqbh = (String) param.get("xqbh");
            String id =  String.valueOf(param.get("id"));
            String gybh = CodeMakeUtils.decade(id);
            param.put("id",id);
            param.put("gybh",gybh);
            param.put("bh",xqbh+gybh);
            int flag2 = liveMapper.AddApartment2(param);
            if(flag2 <= 0){
                throw new RuntimeException("修改失败");
            }
        }
    }

    @Override
    @Transactional
    public void EditApartment(Map<String, Object> param) {
        int flag = liveMapper.EditApartment(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    @Transactional
    public void DeleteApartment(Map<String, Object> param) {
        int flag = liveMapper.DeleteApartment(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public int ExistFloor(Map<String, Object> param) {
        return liveMapper.ExistFloor(param);
    }

    @Override
    public List<Map<String, Object>> QueryFloorList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return liveMapper.QueryFloorList(param);
    }

    @Override
    @Transactional
    public void AddFloor(Map<String, Object> param) {
        int flag = liveMapper.AddFloor1(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }else{
            String xqbh = (String) param.get("xqbh");
            String gybh = (String) param.get("gybh");
            String id =  String.valueOf(param.get("id"));
            String loubh = CodeMakeUtils.hundred(id);
            param.put("id",id);
            param.put("gybh",gybh);
            param.put("xqbh",xqbh);
            param.put("loubh",loubh);
            param.put("bh",xqbh+gybh+loubh);
            int flag2 = liveMapper.AddFloor2(param);
            if(flag2 <= 0){
                throw new RuntimeException("修改失败");
            }
        }
    }

    @Override
    @Transactional
    public void EditFloor(Map<String, Object> param) {
        int flag = liveMapper.EditFloor(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    @Transactional
    public void DelFloor(Map<String, Object> param) {
        int flag = liveMapper.DelFloor(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }
}
