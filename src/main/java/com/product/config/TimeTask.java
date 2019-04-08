package com.product.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;

@Configuration
@EnableScheduling
public class TimeTask {

    /**
     * 更新票数
     * 每天0时更新
     */
//    @Scheduled(cron = "0 0 0 * * ?")
//    @Scheduled(cron = "0 0/1 * * * ?")
    public void gxPs(){
        Date date = new Date();
        System.out.println(date+"定时任务，更新票数成功");
    }

    /**
     * 更新排名
     * 5分钟更新一次
     */

//    @Scheduled(cron = "0 0/5 * * * ?")
    public void gxPm(){
        Date date = new Date();
        System.out.println("更新排名开始时间"+date);
    }
}
