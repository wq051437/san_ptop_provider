package com.jk.service.impl;


import com.jk.dao.PersonalDao;
import com.jk.model.Personalloan;
import com.jk.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 微星 on 2018/5/16.
 */
@Service("personalService")
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalDao personalDao;

    @Override
    public List<Personalloan> queryPersonalloan(Personalloan personalloan) {

        return personalDao.queryPersonalloan(personalloan);
    }

    @Override
    public Personalloan queryLoanById(Integer loanid) {

        return personalDao.queryLoanById(loanid);
    }

//修改审核-------------------------------------------------------------------------------------
    @Override
    public Personalloan queryPersonalloanById(Integer loanid) {

        return personalDao.queryPersonalloanById(loanid);
    }

    @Override
    public void updateLoan(Personalloan personalloan) {
        personalloan.setLoanstate(1);
        personalDao.updateLoan(personalloan);
    }
}
