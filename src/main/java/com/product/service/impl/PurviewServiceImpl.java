package com.product.service.impl;

import com.github.pagehelper.PageHelper;
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
            throw new RuntimeException("增加失败");
        }
    }

    @Override
    @Transactional
    public void EditMenu(Map<String, Object> param) {
        int flag = purviewMapper.EditMenu(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
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
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    @Transactional
    public void AddRole(Map<String, Object> param) {
        int flag = purviewMapper.AddRoleInfo(param);
        Long id ;
        System.out.println("插入执行完成");
        if(flag <= 0){
            throw new RuntimeException("插入执行失败");
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

    @Override
    @Transactional
    public void EditRoleName(Map<String, Object> param) {
        int flag = purviewMapper.EditRoleName(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    @Transactional
    public void EditRoleMenu(Map<String, Object> param) {
        int flag = purviewMapper.DeleteRoleMenu(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }else{
            String menu_id = (String) param.get("menu_id");
            if(menu_id.length()!=0){
                param.put("role_id",param.get("role_id"));
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
    @Override
    @Transactional
    public void EditRole(Map<String, Object> param) {
        int flag = purviewMapper.DeleteRoleMenu(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }else{
            String menu_id = (String) param.get("menu_id");
            if(menu_id.length()!=0){
                param.put("role_id",param.get("role_id"));
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
            int flag2 = purviewMapper.EditRoleName(param);
            if(flag2 <= 0){
                throw new RuntimeException("修改失败");
            }
        }

    }
    @Override
    @Transactional
    public void DeleteRole(Map<String, Object> param) {
        int flag = purviewMapper.DeleteRoleInfo(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }else{
            int flag2 = purviewMapper.DeleteRoleMenu(param);
            if(flag2 <= 0){
                throw new RuntimeException("删除失败");
            }
        }
    }

    @Override
    public int ExistRoleUser(Map<String, Object> param) {
        return purviewMapper.ExistRoleUser(param);
    }

    @Override
    @Transactional
    public void AddUser(Map<String, Object> param) {
        int flag = purviewMapper.AddUser(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }else{
            param.put("user_id",param.get("id"));
            param.put("role_id",0);
            int flag2 = purviewMapper.AddUserRole(param);
            if(flag2 <= 0){
                throw new RuntimeException("添加失败");
            }
        }
    }

    @Override
    @Transactional
    public void AddUserRole(Map<String, Object> param) {
        int flag = purviewMapper.AddUserRole(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    @Transactional
    public void DeleteUser(Map<String, Object> param) {
        int flag = purviewMapper.DeleteUser(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }else{
            int flag2 = purviewMapper.DeleteUserRole(param);
            if(flag2 <= 0){
                throw new RuntimeException("删除失败");
            }
        }
    }

    @Override
    @Transactional
    public void EditUser(Map<String, Object> param) {
        int flag = purviewMapper.EditUser(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    @Transactional
    public void EditUserRole(Map<String, Object> param) {
        int flag = purviewMapper.DeleteUserRole(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }else{
            int flag2 = purviewMapper.AddUserRole(param);
            if(flag2 <= 0){
                throw new RuntimeException("修改失败");
            }
        }
    }

    @Override
    public List<Map<String, Object>> QueryUserList(Map<String, Object> param,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return purviewMapper.QueryUserList(param);
    }

    @Override
    public List<Map<String, Object>> SelectMenu(Map<String, Object> param) {
        return purviewMapper.SelectMenu(param);
    }

    @Override
    public List<Map<String, Object>> RoleList(Map<String, Object> param) {
        return purviewMapper.RoleList(param);
    }
}
