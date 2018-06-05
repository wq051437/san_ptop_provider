package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.WqPeopleNewsDao;
import com.jk.model.CapitalBean;
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

    @Override
    public CapitalBean selectCapital(Integer userid) {
        return wqPeopleNewsDao.selectCapital(userid);
    }

    //查询个人基本信息
    @Override
    public QUserBean selectJbPeopleNews(Integer userid, Integer grid) {
        if(userid != null && !userid.equals("")){
            return wqPeopleNewsDao.selectJbPeopleNews1(userid);
        }else{
            return wqPeopleNewsDao.selectJbPeopleNews(grid);
        }
    }

    @Override
    public GrManagerBean selectJbPeopleNewss(Integer userid, Integer grid) {
        if(userid != null && !userid.equals("")){
            return wqPeopleNewsDao.selectJbPeopleNewss1(userid);
        }else{
            return wqPeopleNewsDao.selectJbPeopleNewss(grid);
        }
    }

    //查询个人学历信息
    @Override
    public JSONObject queryGrEducation(Integer offset, Integer limit, Integer userid) {
        long count = wqPeopleNewsDao.queryGrEducationCount(userid);
        List list=wqPeopleNewsDao.queryGrEducationPage(offset,limit,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //查询个人工作信息
    @Override
    public JSONObject queryGrWork(Integer offset, Integer limit, Integer userid) {
        long count = wqPeopleNewsDao.queryGrWorkCount(userid);
        List list=wqPeopleNewsDao.queryGrWorkPage(offset,limit,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //查询个人房产信息
    @Override
    public JSONObject queryGrRoom(Integer offset, Integer limit, Integer userid) {
        long count = wqPeopleNewsDao.queryGrRoomCount(userid);
        List list=wqPeopleNewsDao.queryGrRoomPage(offset,limit,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //查询个人车产信息
    @Override
    public JSONObject queryGrCar(Integer offset, Integer limit, Integer userid) {
        long count = wqPeopleNewsDao.queryGrCarCount(userid);
        List list=wqPeopleNewsDao.queryGrCarPage(offset,limit,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    //查询个人借款记录
    @Override
    public JSONObject queryGrLoanRecord(Integer offset, Integer limit, Integer userid, String loantitle, String applyloandatestary, String applyloandateend, Integer loanstate) {
        long count = wqPeopleNewsDao.queryGrLoanRecordCount(userid,loantitle,applyloandatestary,applyloandateend,loanstate);
        List list=wqPeopleNewsDao.queryGrLoanRecordPage(offset,limit,userid,loantitle,applyloandatestary,applyloandateend,loanstate);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }
}
