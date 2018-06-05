package com.jk.service.impl;

import com.jk.dao.zxsJkDao;
import com.jk.model.Capital;
import com.jk.model.Companyloan;
import com.jk.model.Personalloan;
import com.jk.model.TArea;
import com.jk.service.zxsJkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 左小山 on 2018/5/21.
 */
@Service("zxsjkservice")
public class zxsJkServiceImpl implements zxsJkService {

@Autowired
private zxsJkDao zxsjkDao;
    //查询地区下拉
    public List<TArea> queryArea() {
        return zxsjkDao.queryArea();
    }

    //个人借款
    public void addjiekuan(Personalloan personalloan,Capital capital) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String applyloandate = sim.format(new Date());
        personalloan.setApplyloandate(applyloandate);
        personalloan.setLoanstate(2);
        personalloan.setMoneyrate(2);
        zxsjkDao.addjiekuan(personalloan);
        zxsjkDao.updateCapital(personalloan);
    }
    //企业借款
    @Override
    public void addqyjiekuan(Companyloan companyloan,Capital capital) {
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        String addcompanyloan = sims.format(new Date());
        companyloan.setApplytime(addcompanyloan);
        companyloan.setLoanrate(5);
        companyloan.setLoanstate(2);
        zxsjkDao.addqyjiekuan(companyloan);
        zxsjkDao.updateqyCapital(companyloan);
    }
    @Override
    public List<Personalloan> queryPersonalloan(Personalloan personalloan) {
        return zxsjkDao.queryPersonalloan(personalloan);
    }
}
