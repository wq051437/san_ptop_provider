package com.jk.service.impl;

import com.alibaba.dubbo.common.json.JSONObject;
import com.jk.dao.CreditorDao;
import com.jk.model.Creditor;
import com.jk.service.CreditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 左小山 on 2018/5/16.
 */
@Service("creditorService")
public class CreditorServiceImpl implements CreditorService {

    @Autowired
    private CreditorDao creditorDao;


    public List<Creditor> queryCreditorList(Creditor creditor) {
        return creditorDao.queryCreditorList(creditor);
    }


//    @Override
//    public long queryCreditorPage() {
//        return creditorDao.queryCreditorPage();
//    }
//
//    @Override
//    public List<Creditor> queryCreditorList(int start, int end) {
//        return creditorDao.queryCreditorList(start,end);
//    }


//    public List<Creditor> queryCreditorPage(Creditor creditor) {
//        // TODO Auto-generated method stub
//        return creditorDao.queryCreditorPage(creditor);
//    }
//    public JSONObject queryCreditorPage(String username, String jiekuantitle, String startDate, String endDate, Integer claimtype) {
////		select * from 表名 limit 起始位置 ，每页条数
////        int start =(page-1)*rows;//起始位置 = (当前页-1)*每页条数
////        long counts = creditorDao.queryCreditorTotal(username,jiekuantitle,startDate,endDate,claimtype);
//        List<Creditor> users = creditorDao.queryCreditorPage(username,jiekuantitle,startDate,endDate,claimtype);
//        JSONObject json = new JSONObject();
////		总条数的key值必须叫total
//       // json.put("total", counts);
////		当前页展示数据的key值必须叫rows
//        json.put("rows", users);
//        return json;
//    }




}
