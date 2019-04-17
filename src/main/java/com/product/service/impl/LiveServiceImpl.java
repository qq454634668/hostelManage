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
            String loubh = CodeMakeUtils.decade(id);
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

    @Override
    public int ExistBedZtLou(Map<String, Object> param) {
        return liveMapper.ExistBedZtLou(param);
    }

    @Override
    public List<Map<String, Object>> QueryRoomList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return liveMapper.QueryRoomList(param);
    }

    @Override
    @Transactional
    public void AddRoom(Map<String, Object> param) {
        //先新增房间，再根据房间标准创建房间床位
        int flag = liveMapper.AddRoom(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }else{
            //根据房间标准，确定循环次数，生成床位编号，
            //获得房间最终编号，再拼床的状态
            String roomzzbh = (String) param.get("bh");    //房间最终编号
            String louzt = (String) param.get("louzt");    //房间最终编号
            String fjbz = (String) param.get("fjbz");
            for(int i=1;i<Integer.parseInt(fjbz)+1;i++){
                String cwbh = CodeMakeUtils.decade(""+i);
                param.put("cwbh",cwbh);
                String bh =roomzzbh+cwbh+louzt;
                param.put("bh",bh);
                int flag2 =liveMapper.AddBed(param);
                if(flag2 <= 0){
                    throw new RuntimeException("添加失败");
                }
            }


        }
    }

    @Override
    @Transactional
    public void EditRoom(Map<String, Object> param) {
        int del1 = liveMapper.DelRoom(param);
        if(del1 <= 0){
            throw new RuntimeException("删除失败");
        }else{
            int del2 = liveMapper.DelBed(param);
            if(del2 <= 0){
                throw new RuntimeException("删除失败");
            }else{
                //先新增房间，再根据房间标准创建房间床位
                int flag = liveMapper.AddRoom(param);
                if(flag <= 0){
                    throw new RuntimeException("再次添加失败");
                }else{
                    //根据房间标准，确定循环次数，生成床位编号，
                    //获得房间最终编号，再拼床的状态
                    String roomzzbh = (String) param.get("bh");    //房间最终编号
                    String louzt = (String) param.get("louzt");    //房间最终编号
                    String fjbz = (String) param.get("fjbz");
                    for(int a=1;a<Integer.parseInt(fjbz)+1;a++){
                        String cwbh = CodeMakeUtils.decade(""+a);
                        param.put("cwbh",cwbh);
                        String bh =roomzzbh+cwbh+louzt;
                        param.put("bh",bh);
                        int flag2 =liveMapper.AddBed(param);
                        if(flag2 <= 0){
                            throw new RuntimeException("再次添加失败");
                        }
                    }


                }
            }

        }

    }

    @Override
    public int ExistRoomRz(Map<String, Object> param) {
        return liveMapper.ExistRoomRz(param);
    }

    @Override
    public int repeatRoom(Map<String, Object> param) {
        return liveMapper.repeatRoom(param);
    }

    @Override
    @Transactional
    public void DelRoom(Map<String, Object> param) {
        int del1 = liveMapper.DelRoom(param);
        if(del1 <= 0){
            throw new RuntimeException("删除失败");
        }else{
            int del2 = liveMapper.DelBed(param);
            if(del2 <= 0){
                throw new RuntimeException("删除失败");
            }
        }

    }

    @Override
    @Transactional
    public void StopRoom(Map<String, Object> param) {
        int flag = liveMapper.StopRoom(param);
        if(flag <= 0){
            throw new RuntimeException("停用失败");
        }
    }

    @Override
    public List<Map<String, Object>> QueryBedList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return liveMapper.QueryBedList(param);
    }

    @Override
    @Transactional
    public void StopBed(Map<String, Object> param) {
        int flag = liveMapper.StopBed(param);
        if(flag <= 0){
            throw new RuntimeException("停用失败");
        }
    }
}
