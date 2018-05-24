package com.jk.dao;

import com.jk.model.Personalloan;
import com.jk.model.TArea;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 左小山 on 2018/5/21.
 */
@Mapper
public interface zxsJkDao {

    //查询地区
    @Select("select * from t_area")
    List<TArea> queryArea();

    //新增借款
   //@Insert("insert into t_personalloan  values(#{loanname},#{loanphone},#{loanmoney},#{loanmonth},#{loantypeid},#{loanadress},#{loandate},#{loandescribe})")
    void addjiekuan(Personalloan personalloan);
}
