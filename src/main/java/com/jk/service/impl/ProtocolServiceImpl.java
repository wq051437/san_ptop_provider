package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.ProtocolDao;
import com.jk.model.Protocol;
import com.jk.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 周玉路 on 2018/5/16.
 */
@Service("protocolService")
public class ProtocolServiceImpl implements ProtocolService {

    @Autowired
    private ProtocolDao protocolDao;

    @Override
    public JSONObject queryProtocolList(Integer offset ,Integer limit, Protocol protocol,String startdate,String enddate,String  grname) {
        long count = protocolDao.queryProtocolManageCount(protocol,startdate,enddate,grname);
        List<Protocol> list=protocolDao.queryProtocolManagePage(offset,limit,protocol,startdate,enddate,grname);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public void updateProtocol() {
        protocolDao.updateProtocol();
    }

    @Override
    public void updatelist(Integer protocolid) {
        protocolDao.updatelist(protocolid);
    }
}
