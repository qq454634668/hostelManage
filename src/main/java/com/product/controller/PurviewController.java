package com.product.controller;

import com.product.service.PurviewService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class PurviewController {
    @Resource
    private PurviewService purviewService;
}
