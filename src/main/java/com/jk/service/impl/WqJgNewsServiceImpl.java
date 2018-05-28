package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.WqJgNewsDao;
import com.jk.model.JgManagerBean;
import com.jk.model.QUserBean;
import com.jk.service.WqJgNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2018/5/22.
 */
@Service("wqJgNewsService")
public class WqJgNewsServiceImpl implements WqJgNewsService {
    @Autowired
    private WqJgNewsDao wqJgNewsDao;
    //查询机构信息
    @Override
    public JSONObject queryJgNews(Integer offset, Integer limit, QUserBean qUserBean, String registerdatestary, String registerdateend, String jgname, String lxrname, String sfyxinvest, String sfyxbuy) {
        long count = wqJgNewsDao.queryJgNewsCount(qUserBean,registerdatestary,registerdateend,jgname,lxrname,sfyxinvest,sfyxbuy);
        List list=wqJgNewsDao.queryJgNewsPage(offset,limit,qUserBean,registerdatestary,registerdateend,jgname,lxrname,sfyxinvest,sfyxbuy);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public List<QUserBean> ExceportAccount() {
        return wqJgNewsDao.ExceportAccount();
    }

    @Override
    public List<JgManagerBean> ExceportJg() {
        return wqJgNewsDao.ExceportJg();
    }

    //回显机构信息
    @Override
    public QUserBean backShowJg(Integer jgid) {
        return wqJgNewsDao.backShowJg(jgid);
    }

    @Override
    public JgManagerBean backShowJgs(Integer jgid) {
        return wqJgNewsDao.backShowJgs(jgid);
    }

    //修改机构信息
    @Override
    public void updateJgUser(JgManagerBean jgManagerBean) {
        wqJgNewsDao.updateJgUser(jgManagerBean);
    }
}
