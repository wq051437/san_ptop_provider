package com.jk.dao;


import com.jk.model.Personalloan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 微星 on 2018/5/16.
 */
@Mapper
public interface PersonalDao {


    List<Personalloan> queryPersonalloan(Personalloan personalloan);


    @Select("select * from t_personalloan where loanid=#{loanid}")
    Personalloan queryLoanById(Integer loanid);

//修改审核-------------------------------------------------------------------------------------
    @Select("select * from t_personalloan where loanid=#{loanid}")
    Personalloan queryPersonalloanById(Integer loanid);

    //@Update("update t_personalloan tp set tp.loanstate = #{loanstate},tp.pr     ocess=#{process} where tp.loanid=#{loanid}")
    void updateLoan(Personalloan personalloan);
}
