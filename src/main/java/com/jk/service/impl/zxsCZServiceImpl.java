package com.jk.service.impl;

import com.jk.dao.zxsCZDao;
import com.jk.dao.zxsJkDao;
import com.jk.model.Capital;
import com.jk.model.Recharge;
import com.jk.service.zxsCZService;
import com.jk.service.zxsJkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 左小山 on 2018/5/28.
 */
@Service("zxsczService")
public class zxsCZServiceImpl implements zxsCZService {

    @Autowired
    private zxsCZDao zxsczDao;

    @Override
    public void addCZje(Recharge recharge,Capital capital) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String addTime = sim.format(new Date());
        recharge.setFinishdate(addTime);//充值时间
       // recharge.setRechargenumber(2);//订单号
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyyMMdd");
        String addTime1 = sim1.format(new Date());
        Date   date=new Date();
        recharge.setSerialnumber(date.getTime());//流水单号
        recharge.setRechargenumber(date.getTime());//订单号
        recharge.setRechargestate(2);
        zxsczDao.addCZje(recharge);
        zxsczDao.updateCapital(capital);
    }

    @Override
    public Capital queryCapital(Capital capital, Integer userid) {
        return zxsczDao.queryCapital(capital,userid);
    }

    //报表
    @Override
    public List<Capital> queryReceipt(Capital capital, Integer userid) {
        return zxsczDao.queryReceipt(capital,userid);
    }
}
