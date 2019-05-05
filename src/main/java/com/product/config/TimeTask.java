package com.product.config;

import com.product.pojo.TaskBaseinfo;
import com.product.pojo.TaskDetailed;
import com.product.pojo.UserStudent;
import com.product.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;




@Configuration
@EnableScheduling
public class TimeTask {


    @Autowired
    private TaskService taskService;


    @Scheduled(cron = "0/30 * * * * ?")
    public void autoMode(){

        taskService.rwfp();

    }
}
