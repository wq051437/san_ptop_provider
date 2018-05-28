package com.jk.dao;

import com.jk.model.Personalloan;
import com.jk.model.Recharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 微星 on 2018/5/24.
 */
@Mapper
public interface FinanceDao {


    List<Recharge> queryrecharge(Recharge recharge);

//放款查询---------------------------------------------------------------------------------------
    List<Recharge> querylend(Personalloan personalloan);
}
