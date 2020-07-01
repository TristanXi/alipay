package com.tristan.exam.alipay.tranfer.controller;

import com.tristan.exam.alipay.tranfer.annotation.LoginRequired;
import com.tristan.exam.alipay.tranfer.model.Response;
import com.tristan.exam.alipay.tranfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: alipay
 * @description:
 * @author: Tristan.Xi
 * @create: 2020-07-01 15:40
 **/

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    /*
    *用户登陆鉴权信息放在header里，检测登陆情况
    *异步调用
    * */
    @LoginRequired
    @PostMapping(value = "/")
    public Response<?> transferWithBalance(long fromId,long toId, long amount) {
        Response<?> response = new Response<>();
        try {
           transferService.transfer(fromId,toId,amount);
        } catch (Exception e) {
            //根据异常设置相关code
            //todo
            //设置错误信息
            response.setServerErrorMsg(e.toString());
        }

        return response;
    }

}
