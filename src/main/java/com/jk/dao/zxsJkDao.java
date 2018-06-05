package com.jk.dao;

import com.jk.model.Companyloan;
import com.jk.model.Personalloan;
import com.jk.model.TArea;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 左小山 on 2018/5/21.
 */
@Mapper
public interface zxsJkDao {

    //查询地区
    @Select("select * from t_area")
    List<TArea> queryArea();

    //个人借款
    //@Insert("insert into t_personalloan  values(#{loanname},#{loanphone},#{loanmoney},#{loanmonth},#{loantypeid},#{loanadress},#{loandate},#{loandescribe})")
    void addjiekuan(Personalloan personalloan);
    @Update("update p_capital c set c.capitalmoney=c.capitalmoney+#{loanmoney} where c.userid=#{userid}")
    void updateCapital(Personalloan personalloan);

    //企业借款
    void addqyjiekuan(Companyloan companyloan);
    @Update("update p_capital c set c.capitalmoney=c.capitalmoney+#{loanmoney} where c.userid=#{userid}")
    void updateqyCapital(Companyloan companyloan);
    //我的借款-还款中
    @Select("select * from t_personalloan")
    List<Personalloan> queryPersonalloan(Personalloan personalloan);
}
