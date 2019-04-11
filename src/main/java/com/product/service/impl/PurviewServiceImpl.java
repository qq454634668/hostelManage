package com.product.service.impl;

import com.product.mapper.PurviewMapper;
import com.product.service.PurviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurviewServiceImpl implements PurviewService {

    @Resource
    private PurviewMapper purviewMapper;

    @Override
    @Transactional
    public void AddMenu(Map<String, Object> param) {
        int flag = purviewMapper.AddMenu(param);
        if(flag <= 0){
            throw new RuntimeException("增加次数失败");
        }
    }

    @Override
    @Transactional
    public void EditMenu(Map<String, Object> param) {
        int flag = purviewMapper.EditMenu(param);
        if(flag <= 0){
            throw new RuntimeException("修改次数失败");
        }
    }

    @Override
    public List<Map<String, Object>> QueryMenu(Map<String, Object> param) {
        List<Map<String, Object>> result = new ArrayList<>();
        param.put("parent_id",0);
        List<Map<String, Object>> parentMenu  = purviewMapper.QueryMenu(param);
        for(int i=0;i<parentMenu.size();i++){
            Map<String,Object> zsMap = parentMenu.get(i);
            Map<String,Object> resultMap = new HashMap<>();
            param.put("parent_id",zsMap.get("id"));
            List<Map<String, Object>> sonMenu = purviewMapper.QueryMenu(param);
            resultMap.put("parentMenu",zsMap);
            resultMap.put("sonMenu",sonMenu);
            result.add(resultMap);
        }
        return result;
    }

    @Override
    @Transactional
    public void DeleteMenu(Map<String, Object> param) {
        int flag = purviewMapper.DeleteMenu(param);
        if(flag <= 0){
            throw new RuntimeException("删除次数失败");
        }
    }

    @Override
    @Transactional
    public void AddRole(Map<String, Object> param) {
        int flag = purviewMapper.AddRoleInfo(param);
        Long id ;
        System.out.println("删除执行完成");
        if(flag <= 0){
            throw new RuntimeException("删除次数失败");
        }else{
            String menu_id = (String) param.get("menu_id");
            if(menu_id.length()!=0){
                id = (Long) param.get("id");
                System.out.println("自增长ID========="+id);
                param.put("role_id",id);
                String[] menuId_String = menu_id.split(",");
                List menuId_List =new ArrayList();
                for(int i=0;i<menuId_String.length;i++){
                    Map<String,Object> lsMap = new HashMap<>();
                    lsMap.put("menu_id",menuId_String[i]);
                    menuId_List.add(lsMap);
                }
                param.put("menuId_List",menuId_List);
                purviewMapper.AddRoleMenu(param);
            }
        }

    }
}
