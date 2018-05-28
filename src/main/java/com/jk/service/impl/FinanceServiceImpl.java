package com.jk.service.impl;

import com.jk.dao.FinanceDao;
import com.jk.model.Personalloan;
import com.jk.model.Recharge;
import com.jk.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 微星 on 2018/5/24.
 */
@Service("financeService")
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceDao financeDao;

    @Override
    public List<Recharge> queryrecharge(Recharge recharge) {
        return financeDao.queryrecharge(recharge);
    }

//放款查询---------------------------------------------------------------------------------------
    @Override
    public List<Recharge> querylend(Personalloan personalloan) {
        return financeDao.querylend(personalloan);
    }
}
