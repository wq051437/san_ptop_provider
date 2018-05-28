package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.WqQyNewsDao;
import com.jk.model.QUserBean;
import com.jk.model.QyManagerBean;
import com.jk.service.WqQyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2018/5/22.
 */
@Service("wqQyNewsService")
public class WqQyNewsServiceImpl implements WqQyNewsService {
    @Autowired
    private WqQyNewsDao wqQyNewsDao;
    //查询企业信息
    @Override
    public JSONObject queryQyNews(Integer offset, Integer limit, QUserBean qUserBean, String registerdatestary, String registerdateend, String qyname, String lxrname, String sfyxinvest) {
        long count = wqQyNewsDao.queryQyNewsCount(qUserBean,registerdatestary,registerdateend,qyname,lxrname,sfyxinvest);
        List list=wqQyNewsDao.queryQyNewsPage(offset,limit,qUserBean,registerdatestary,registerdateend,qyname,lxrname,sfyxinvest);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //导出企业信息
    @Override
    public List<QyManagerBean> ExceportQy() {
        return wqQyNewsDao.ExceportQy();
    }

    @Override
    public List<QUserBean> ExceportAccount() {
        return wqQyNewsDao.ExceportAccount();
    }

    //回显企业信息
    @Override
    public QUserBean backShowQy(Integer qyid) {
        return wqQyNewsDao.backShowQy(qyid);
    }

    @Override
    public QyManagerBean backShowQys(Integer qyid) {
        return wqQyNewsDao.backShowQys(qyid);
    }

    //修改企业信息
    @Override
    public void updateQyUser(QyManagerBean qyManagerBean) {
        wqQyNewsDao.updateQyUser(qyManagerBean);
    }
}
