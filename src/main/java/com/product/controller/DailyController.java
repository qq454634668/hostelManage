package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.DailyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日常管理功能
 */
@Controller
@RequestMapping("/daily")
public class DailyController {
    @Resource
    private DailyService dailyService;



    /**--------------------------------菜单 start----------------------------------------*/


    /**--------------------------------菜单 end----------------------------------------*/


}
