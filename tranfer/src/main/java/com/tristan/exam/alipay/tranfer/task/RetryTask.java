package com.tristan.exam.alipay.tranfer.task;

import com.tristan.exam.alipay.tranfer.recover.TransactionRecovery;
import com.tristan.exam.alipay.tranfer.service.RecoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: alipay
 * @description: retry transfer
 * @author: Tristan.Xi
 * @create: 2020-07-01 10:17
 **/
@Component
@EnableScheduling
public class RetryTask {

    @Autowired
    private RecoverService recoverService;


    @Scheduled(cron = "${retry.microsecond.count}")
    public void crawlGeneralSeeds() {
        recoverService.startRecover();
    }
}

