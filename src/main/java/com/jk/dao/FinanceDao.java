package com.jk.dao;

import com.jk.model.Capital;
import com.jk.model.Companyloan;
import com.jk.model.Personalloan;
import com.jk.model.Recharge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 微星 on 2018/5/24.
 */
@Mapper
public interface FinanceDao {


    List<Recharge> queryrecharge(@Param("recharge") Recharge recharge);

//放款查询---------------------------------------------------------------------------------------
    List<Personalloan> querylend(@Param("personalloan") Personalloan personalloan);


//修改金额-----------------------------------------------------------------
    //@Select("select tp.loanid,tp.loantitle,tp.loanmoney,tp.moneyrate,tp.loanmonth,tp.lendstate,pc.* from p_capital pc,t_personalloan tp,p_user pu where pc.userid=pu.userid and pu.userid=tp.userid and tp.loanid=#{loanid}")
    List queryLoanByIds(@Param("loanid") Integer loanid);

    void updatePersonalloanById(@Param("personalloan") Personalloan personalloan);

    void updateCapitalLoanById(@Param("capital") Capital capital, @Param("loanmoney") Double loanmoney);

//查询公司借款-----------------------------------------------------------------
    List<Companyloan> queryCompany(@Param("companyloan") Companyloan companyloan);

//修改公司借款回显-----------------------------------------------------------------
    List queryCompanyById(@Param("companyid") Integer companyid);

    void updateCompany(@Param("companyloan") Companyloan companyloan);

    void updateCapitalLoan(@Param("capital") Capital capital, @Param("loanmoney") Double loanmoney);
}
