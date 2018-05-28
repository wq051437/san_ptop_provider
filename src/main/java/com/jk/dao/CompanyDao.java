package com.jk.dao;

import com.jk.model.Companyloan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 微星 on 2018/5/23.
 */
@Mapper
public interface CompanyDao {

    List<Companyloan> queryCompanyloanloan(Companyloan companyloan);

    @Select("select * from t_companyloan where companyid=#{companyid}")
    Companyloan queryLoanById(Integer companyid);

    void updateLoan(Companyloan companyloan);
}
