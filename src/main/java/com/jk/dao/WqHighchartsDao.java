package com.jk.dao;

import com.jk.model.Invest;
import com.jk.model.InvestRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ASUS on 2018/5/30.
 */
@Mapper
public interface WqHighchartsDao {

    //查询会员统计
    List highchartsVipTj();

    //余额统计
    List highchartsYeTj();

    //借款统计
    List highchartsJkTj();

    //查询投资
    List queryInvest();

    //跟进ID查询投资信息
    Invest queryInvestById(@Param("investid")Integer investid);

    List queryinvestRecordById(@Param("investid")Integer investid);

    //添加投资记录
    void addInvestRecord(InvestRecord investRecord);

    void updateInvestRecordByq(InvestRecord investRecord);
}
