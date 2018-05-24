package com.jk.service.impl;

import com.jk.dao.zxsJkDao;
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

    //新增
    public void addjiekuan(Personalloan personalloan) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String applyloandate = sim.format(new Date());
        personalloan.setApplyloandate(applyloandate);
        personalloan.setLoanstate(2);
        zxsjkDao.addjiekuan(personalloan);
    }
}
