package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.QUserDao;
import com.jk.model.*;
import com.jk.service.QUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by new鹏 on 2018/5/18.
 */
@Service("qUserService")
public class QUserServiceImpl   implements QUserService{
    @Resource
    private QUserDao qUserDao;
    @Override
    public QUserBean login(QUserBean qUserBean) {
        return qUserDao.login(qUserBean);
    }

    @Override
    public void updatedate(Integer userid) {
        SimpleDateFormat   simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String q = simpleDateFormat.format(new Date());
        qUserDao.updatedate(userid,q);
    }

    @Override
    public List querygerenlist(Integer userid) {
        List   list=new ArrayList();
        List  list2=   qUserDao.querygerenlist(userid);
        List  list3= qUserDao.querygerenlist2(userid);
        list.add(list2);
        list.add(list3);
        return list;
    }

    @Override
    public void updatemima(Integer userid, String userpass) {
        qUserDao.updatemima(userid,userpass);
    }

    @Override
    public void updatejiaoyimima(String jiaoyi, Integer userid) {
        qUserDao.updatejiaoyimima(jiaoyi,userid);
    }

    @Override
    public void addphoto(String fileUrl, Integer userid) {
        qUserDao.addphoto(fileUrl,userid);
    }

    @Override
    public String addphotolist(String qname) {
        return qUserDao.addphotolist(qname);
    }
    @Override
    public JSONObject queryeducationlistlist(Integer offset, Integer limit, Integer userid) {
        long count = qUserDao.queryeducationlistCount(userid);
        List list=qUserDao.queryeducationlist(offset,limit,userid);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public void addeducationlist(EducationBean educationBean) {
        qUserDao.addeducationlist(educationBean);
    }

    @Override
    public List queryupdatelist(Integer stuid) {
        return qUserDao.queryupdatelist(stuid);
    }

    @Override
    public void updateeducationlist(EducationBean educationBean) {
        qUserDao.updateeducationlist(educationBean);
    }

    @Override
    public JSONObject queryworklist(Integer offset, Integer limit, Integer userid) {
        long count = qUserDao.queryworklistCount(userid);
        List list=qUserDao.queryworklist(offset,limit,userid);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public List queryaddresslist() {
        return qUserDao.queryaddresslist();
    }

    @Override
    public void addworklist(WorkBean workBean) {
        qUserDao.addworklist(workBean);
    }

    @Override
    public List queryupdateworklist(Integer workid) {
        return qUserDao.queryupdateworklist(workid);
    }

    @Override
    public void updateworklist(WorkBean workBean) {
        qUserDao.updateworklist(workBean);
    }

    @Override
    public JSONObject queryroomlist(Integer offset, Integer limit, Integer userid) {
        long count = qUserDao.queryroomlistCount(userid);
        List list=qUserDao.queryroomlist(offset,limit,userid);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public void addroomlist(RoomBean roomBean) {
        qUserDao.addroomlist(roomBean);
    }

    @Override
    public List queryupdateroomlist(Integer roomid) {

        return qUserDao.queryupdateroomlist(roomid);
    }

    @Override
    public void updateroomlist(RoomBean roomBean) {
        qUserDao.updateroomlist(roomBean);
    }

    @Override
    public JSONObject querycarlist(Integer offset, Integer limit, Integer userid) {
        long count = qUserDao.querycarlistCount(userid);
        List list=qUserDao.querycarlist(offset,limit,userid);
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public void addcarlist(CarBean carBean) {
        qUserDao.addcarlist(carBean);
    }

    @Override
    public List queryupdatecarlist(Integer carid) {

        return qUserDao.queryupdatecarlist(carid);
    }

    @Override
    public void updatecarlist(CarBean carBean) {
        qUserDao.updatecarlist(carBean);
    }

    @Override
    public QUserBean addpanduanphone(String phone) {
        return qUserDao.addpanduanphone(phone);
    }

    @Override
    public void addpuserlist(QUserBean qUserBean) {
        qUserDao.addpuserlist(qUserBean);
    }
}
