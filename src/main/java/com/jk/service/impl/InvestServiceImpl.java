package com.jk.service.impl;

import com.jk.dao.InvestDao;
import com.jk.model.Invest;
import com.jk.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 微星 on 2018/5/31.
 */
@Service("investService")
public class InvestServiceImpl implements InvestService {

    @Autowired
    private InvestDao investDao;


    @Override
    public List<Invest> queryInvest(Invest invest) {

        return investDao.queryInvest(invest);
    }

    @Override
    public Invest queryInvestById(Integer investid) {

        return investDao.queryInvestById(investid);
    }

    @Override
    public void updateInvestById(Invest invest) {

        SimpleDateFormat sima = new SimpleDateFormat("yyyy-MM-dd");
        String lendtime = sima.format(new Date());

        invest.setLendtime(lendtime);


        investDao.updateInvestById(invest);
    }

    @Override
    public void updateInvesttwo(Invest invest) {

        SimpleDateFormat sima = new SimpleDateFormat("yyyy-MM-dd");
        String lendtime = sima.format(new Date());

        invest.setLendtime(lendtime);
        invest.setLendstate(3);

        investDao.updateInvesttwo(invest);

    }

    @Override
    public void updateInvests(Invest invest) {
        SimpleDateFormat sima = new SimpleDateFormat("yyyy-MM-dd");
        String lendtime = sima.format(new Date());

        invest.setLendtime(lendtime);
        invest.setLendstate(4);

        investDao.updateInvests(invest);

    }
}
