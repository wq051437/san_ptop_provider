package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.WqAccountManageDao;
import com.jk.model.GrManagerBean;
import com.jk.model.QUserBean;
import com.jk.model.QyManagerBean;
import com.jk.service.WqAccountManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/5/16.
 */
@Service("wqAccountManageService")
public class WqAccountManageServiceImpl implements WqAccountManageService {

    @Autowired
    private WqAccountManageDao wqAccountManageDao;

    //查询账户信息
    @Override
    public JSONObject queryAccountManage(Integer offset,Integer limit, QUserBean qUserBean,String registerdatestary,String registerdateend) {
        long count = wqAccountManageDao.queryAccountManageCount(qUserBean,registerdatestary,registerdateend);
        List<QUserBean> list=wqAccountManageDao.queryAccountManagePage(offset,limit,qUserBean,registerdatestary,registerdateend);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //导出账户信息
    @Override
    public List<QUserBean> queryAccount() {
        return wqAccountManageDao.queryAccount();
    }

    //锁定
    @Override
    public void lockAccount(QUserBean qUserBean) {
        qUserBean.setUserstate("锁定");
        wqAccountManageDao.lockAccount(qUserBean);
    }

    //解锁
    @Override
    public void deblockingAccount(QUserBean qUserBean) {
        qUserBean.setUserstate("启用");
        wqAccountManageDao.deblockingAccount(qUserBean);
    }

    //获取用户名称
    @Override
    public QUserBean backShowUsername(Integer userid) {
        return wqAccountManageDao.backShowUsername(userid);
    }

    //新增企业信息
    @Override
    public void addQyUser(QUserBean qUserBean, QyManagerBean qyManagerBean) {
        List list = wqAccountManageDao.queryQyUsersf(qUserBean);
        if(list.size()==0){
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            String addGrUserTime = sim.format(new Date());
            qUserBean.setRegisterdate(addGrUserTime);
            qUserBean.setUserpass("123456");
            qUserBean.setUserstate("启用");
            wqAccountManageDao.addQyUser(qUserBean);
            int userid = wqAccountManageDao.queryQyUserId(qUserBean);
            qyManagerBean.setUserid(userid);
            wqAccountManageDao.addQyUsers(qyManagerBean);
        }
    }

    //拉黑
    @Override
    public void blockAccount(QUserBean qUserBean) {
        qUserBean.setUserstate("黑名单");
        wqAccountManageDao.blockAccount(qUserBean);
    }

    //取消拉黑
    @Override
    public void qxBlockAccount(QUserBean qUserBean) {
        qUserBean.setUserstate("启用");
        wqAccountManageDao.qxBlockAccount(qUserBean);
    }

    //添加个人信息
    @Override
    public void addGrUser(QUserBean qUserBean, GrManagerBean grManagerBean) {
        List list = wqAccountManageDao.queryGrUsersf(qUserBean);
        if(list.size()==0){
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            String addGrUserTime = sim.format(new Date());
            qUserBean.setRegisterdate(addGrUserTime);
            wqAccountManageDao.addGrUser(qUserBean);
            int userid = wqAccountManageDao.queryQUserId(qUserBean);
            grManagerBean.setUserid(userid);
            wqAccountManageDao.addGrUsers(grManagerBean);
        }
    }

}
