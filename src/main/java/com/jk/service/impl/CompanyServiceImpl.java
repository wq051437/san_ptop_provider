package com.jk.service.impl;

import com.jk.dao.CompanyDao;
import com.jk.model.Companyloan;
import com.jk.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 微星 on 2018/5/23.
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;


    @Override
    public List<Companyloan> queryCompanyloanloan(Companyloan companyloan) {
        return companyDao.queryCompanyloanloan(companyloan);
    }

    @Override
    public Companyloan queryLoanById(Integer companyid) {
        return companyDao.queryLoanById(companyid);
    }

    @Override
    public void updateLoan(Companyloan companyloan) {
        SimpleDateFormat sima = new SimpleDateFormat("yyyy-MM-dd");
        String resulttime = sima.format(new Date());
        companyloan.setResulttime(resulttime);
        companyloan.setLoanstate(1);
        companyDao.updateLoan(companyloan);
    }
}
