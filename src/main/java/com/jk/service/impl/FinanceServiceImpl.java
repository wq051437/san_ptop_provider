package com.jk.service.impl;

import com.jk.dao.FinanceDao;
import com.jk.model.Capital;
import com.jk.model.Companyloan;
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
    public List<Personalloan> querylend(Personalloan personalloan) {

        return financeDao.querylend(personalloan);
    }

//修改金额-----------------------------------------------------------------
    @Override
    public List queryLoanByIds(Integer loanid) {

        return financeDao.queryLoanByIds(loanid);
    }

    @Override
    public void updateLoanById(Personalloan personalloan, Capital capital) {
        financeDao.updatePersonalloanById(personalloan);
        Double loanmoney = personalloan.getLoanmoney();
        financeDao.updateCapitalLoanById(capital,loanmoney);
    }

//查询公司借款-----------------------------------------------------------------
    @Override
    public List<Companyloan> queryCompany(Companyloan companyloan) {

        return financeDao.queryCompany(companyloan);
    }

//修改公司借款回显-----------------------------------------------------------------
    @Override
    public List queryCompanyById(Integer companyid) {

        return financeDao.queryCompanyById(companyid);
    }

    @Override
    public void updateCompanyById(Companyloan companyloan, Capital capital) {

        financeDao.updateCompany(companyloan);
        Double loanmoney=companyloan.getLoanmoney();

        financeDao.updateCapitalLoan(capital,loanmoney);

    }


}
