package com.jk.service.impl;

import com.jk.dao.QUserDao;
import com.jk.model.QUserBean;
import com.jk.service.QUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
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
        return qUserDao.querygerenlist(userid);
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


}
