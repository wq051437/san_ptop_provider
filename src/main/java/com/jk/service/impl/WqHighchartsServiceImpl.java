package com.jk.service.impl;

import com.jk.dao.WqHighchartsDao;
import com.jk.model.Invest;
import com.jk.model.InvestRecord;
import com.jk.service.WqHighchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS on 2018/5/30.
 */
@Service("wqHighchartsService")
public class WqHighchartsServiceImpl implements WqHighchartsService {
    @Autowired
    private WqHighchartsDao wqHighchartsDao;
    //会员统计
    @Override
    public List highchartsVipTj() {
        return wqHighchartsDao.highchartsVipTj();
    }

    //余额统计
    @Override
    public List highchartsYeTj() {
        return wqHighchartsDao.highchartsYeTj();
    }

    //借款统计
    @Override
    public List highchartsJkTj() {
        return wqHighchartsDao.highchartsJkTj();
    }

    @Override
    public List queryInvest() {
        return wqHighchartsDao.queryInvest();
    }

    //跟进ID查询投资信息
    @Override
    public Invest queryInvestById(Integer investid) {
        return wqHighchartsDao.queryInvestById(investid);
    }

    @Override
    public List queryinvestRecordById(Integer investid) {
        return wqHighchartsDao.queryinvestRecordById(investid);
    }

    //添加投资记录
    @Override
    public void addInvestRecord(InvestRecord investRecord) {
        wqHighchartsDao.addInvestRecord(investRecord);
        Double qian = investRecord.getInvestrecordmaney();
        wqHighchartsDao.updateInvestRecordByq(investRecord);
    }
}
