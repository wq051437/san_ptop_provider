package com.jk.dao;

import com.jk.model.Invest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 微星 on 2018/5/31.
 */
@Mapper
public interface InvestDao {


    List<Invest> queryInvest(Invest invest);

    @Select("select * from t_invest where investid=#{investid}")
    Invest queryInvestById(Integer investid);

    void updateInvestById(Invest invest);

    void updateInvesttwo(Invest invest);

    void updateInvests(Invest invest);
}
