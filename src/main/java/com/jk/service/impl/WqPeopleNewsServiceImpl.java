package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.WqPeopleNewsDao;
import com.jk.model.GrManagerBean;
import com.jk.model.QUserBean;
import com.jk.service.WqPeopleNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2018/5/21.
 */
@Service("wqPeopleNewsService")
public class WqPeopleNewsServiceImpl implements WqPeopleNewsService {

    @Autowired
    private WqPeopleNewsDao wqPeopleNewsDao;

    //查询个人信息
    @Override
    public JSONObject queryPeopleNews(Integer offset,Integer limit, QUserBean qUserBean, String registerdatestary, String registerdateend, String grname) {
        long count = wqPeopleNewsDao.queryPeopleNewsCount(qUserBean,registerdatestary,registerdateend,grname);
        List list=wqPeopleNewsDao.queryPeopleNewsPage(offset,limit,qUserBean,registerdatestary,registerdateend,grname);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //回显个人信息
    @Override
    public QUserBean backShowPeopleNews(Integer grid) {
        return wqPeopleNewsDao.backShowPeopleNews(grid);
    }
    @Override
    public GrManagerBean backShowPeopleNewss(Integer grid) {
        return wqPeopleNewsDao.backShowPeopleNewss(grid);
    }

    //修改个人信息
    @Override
    public void updateGrUser(QUserBean qUserBean) {
        wqPeopleNewsDao.updateGrUser(qUserBean);
    }

    //导出个人信息
    @Override
    public List<GrManagerBean> ExceportPeopleNews() {
        return wqPeopleNewsDao.ExceportPeopleNews();
    }

    @Override
    public List<QUserBean> ExceportAccount() {
        return wqPeopleNewsDao.ExceportAccount();
    }
}
