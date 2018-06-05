package com.jk.service.impl;

import com.jk.dao.CollectionDao;
import com.jk.model.Online;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    @Resource
    private CollectionDao collectionDao;
    @RabbitHandler
    public void process(Online online) {
        if(online.getOnlinetype().equals("短信")){
            System.out.println("11");
          collectionDao.addonlinelist(online);
        }else  if(online.getOnlinetype().equals("邮箱")){
            System.out.println("22");
   collectionDao.addonclinelist(online);
        }
    }

}
