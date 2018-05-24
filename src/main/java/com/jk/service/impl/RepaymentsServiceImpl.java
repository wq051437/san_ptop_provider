package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.RepaymentsDao;
import com.jk.model.Personalloan;
import com.jk.service.RepaymentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by new鹏 on 2018/5/17.
 */
@Service("repaymentsService")
public class RepaymentsServiceImpl  implements RepaymentsService{

    @Resource
    private RepaymentsDao repaymentsDao;

    @Override
    public JSONObject queryrepaymentslist(Integer offset, Integer limit) {
        Long count = repaymentsDao.getrepaymentsSum();
        List<Personalloan> list = repaymentsDao.getrepaymentslist(offset,limit);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }
}
