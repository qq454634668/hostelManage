package com.product.controller;

import com.product.service.PurviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限功能
 */
@Controller
@RequestMapping("/purview")
public class PurviewController {
    @Resource
    private PurviewService purviewService;

    /**
     * 增加菜单
     * @parent_id
     * @name  菜单名
     * @return
     */
    @RequestMapping("/AddMenu")
    @ResponseBody
    public Map<String,Object> AddMenu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String parent_id = request.getParameter("parent_id");
            String name = request.getParameter("name");
            String url = request.getParameter("url");
            String icon = request.getParameter("icon");
            String px = request.getParameter("px");
            param.put("parent_id",parent_id);
            param.put("name",name);
            param.put("url",url);
            param.put("icon",icon);
            param.put("px",px);
            purviewService.AddMenu(param);
            result.put("message","添加菜单成功");
            result.put("code","200");
            result.put("data",null);
        }catch (Exception e){
            result.put("message","添加菜单失败");
            result.put("code","500");
            result.put("data",null);
        }
        return result;
    }
}
