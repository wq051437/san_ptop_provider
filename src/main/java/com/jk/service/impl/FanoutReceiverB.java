package com.jk.service.impl;

import com.jk.model.Online;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(Online online) {
        if(online.getOnlinetype().equals("邮箱")){
            String context = "尊敬的客户,你好,你的还款日期已经接近，请尽快还上。";
            String title = "火星网贷";
          Email ok = new Email(online.getOnlinemailbox(),context,title);
          try {
                String o = ok.sf();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
