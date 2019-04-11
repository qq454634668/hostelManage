package com.product.service.impl;

import com.product.mapper.PurviewMapper;
import com.product.service.PurviewService;
import org.springframework.stereotype.Service;

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
    public void AddMenu(Map<String, Object> param) {
        purviewMapper.AddMenu(param);
    }

    @Override
    public void EditMenu(Map<String, Object> param) {
        purviewMapper.EditMenu(param);
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
}
