package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.CollectionDao;
import com.jk.model.CollectionBean;
import com.jk.model.Online;
import com.jk.model.Protocol;
import com.jk.service.CollectionService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by new鹏 on 2018/5/29.
 */
@Service("collectionService")
public class CollectionServiceImpl   implements CollectionService {
    @Resource
    private CollectionDao collectionDao;

    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Override
    public void addunclinelist(CollectionBean collectionBean) {
        collectionDao.addunclinelist(collectionBean);
    }

    @Override
    public JSONObject querycollectionlist(Integer offset, Integer limit, Integer loanid) {
        long count = collectionDao.querycollectionCount(loanid);
        List list=collectionDao.querycollectionlist(offset,limit,loanid);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public List addchaxuqiu(Integer userid) {
        List  list=  collectionDao.addchaxuqiu(userid);
        return list;
    }

    @Override
    public void addonlinelist(Online online) {
        this.rabbitTemplate.convertAndSend("fanoutExchange","", online);

    }

    @Override
    public void addonclinelist(Online online) {
        this.rabbitTemplate.convertAndSend("fanoutExchange","", online);
    }

    @Override
    public JSONObject queryunderlinelist(Integer offset, Integer limit,String  username,String  collectiontype,String  starttimess,String  endtimess) {
        long count = collectionDao.queryunderlineCount(username,collectiontype,starttimess,endtimess);
        List list=collectionDao.queryunderlinelist(offset,limit,username,collectiontype,starttimess,endtimess);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public JSONObject queryonlinelist(Integer offset, Integer limit,String  username,String  collectiontype,String  starttimess,String  endtimess) {
        long count = collectionDao.queryonlineCount(username,collectiontype,starttimess,endtimess);
        List list=collectionDao.queryonlinelist(offset,limit,username,collectiontype,starttimess,endtimess);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }


    @Override
    public List querydetailsUnderline(Integer collectionid) {
        return   collectionDao.querydetailsUnderline(collectionid);

    }

    @Override
    public List querydetailsonline(Integer onlineid) {

        return collectionDao.querydetailsonline(onlineid);
    }
}
