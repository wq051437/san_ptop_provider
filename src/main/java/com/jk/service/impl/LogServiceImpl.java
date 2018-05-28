package com.jk.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.jk.LoggerDao.LoggerDao;
import com.jk.model.Logs;
import com.jk.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周玉路 on 2018/5/27.
 */
@Service("logService")
public class LogServiceImpl implements LogService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private   LoggerDao    loggerDao;

    public JSONObject addloggerlist(Integer offset, Integer limit) {
        Long count = loggerDao.getcount();
        List list = loggerDao.getList(offset,limit);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }
    /* (non-Javadoc)
	 * 日志统计报表
	 */
    public List selecttongji() {
        List list =new ArrayList();
        Query query = new Query();
        //求所有
        Query query1 = new Query();
        Query query2 = new Query();
        Query query3 = new Query();
        //发生异常的统计，异常中出的错
        long countz = mongoTemplate.count(query, Logs.class);
        String methodName = "methodName";//条件查询！！！如下：方法
        query.addCriteria(Criteria.where(methodName).regex(".*?\\发生.*"));
        query1.addCriteria(Criteria.where(methodName).regex("save.*"));
        query2.addCriteria(Criteria.where(methodName).regex("delete.*"));
        query3.addCriteria(Criteria.where(methodName).regex("update.*"));
        long county = mongoTemplate.count(query, Logs.class);
        //两者相减得差
        long countzeng = mongoTemplate.count(query1, Logs.class);
        long countshan = mongoTemplate.count(query2, Logs.class);
        long countgai = mongoTemplate.count(query3, Logs.class);
        long countcha = countz-countzeng-countshan-countgai;
        //查询的
        long countr = countz-county;
        list.add(countr);
        list.add(countz);
        list.add(county);
        //返回 list
        list.add(countzeng);
        list.add(countshan);
        list.add(countgai);
        list.add(countcha);
        return list;
    }
}
