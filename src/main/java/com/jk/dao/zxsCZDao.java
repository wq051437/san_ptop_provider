package com.jk.dao;

import com.jk.model.Capital;
import com.jk.model.Recharge;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 左小山 on 2018/5/28.
 */
@Mapper
public interface zxsCZDao {


    @Insert("insert into t_recharge(rechargenumber,userid,rechargemoney,receivable,received,finishdate,paycompany,rechargestate,serialnumber)\n" +
            "values(#{rechargenumber},#{userid},#{rechargemoney},#{receivable},#{received},#{finishdate},#{paycompany},#{rechargestate},#{serialnumber})")
    void addCZje(Recharge recharge);

    @Update("update p_capital c set c.capitalmoney=c.capitalmoney+#{capital.capitalmoney} where c.userid=#{capital.userid}")
    void updateCapital(@Param("capital") Capital capital);

    @Select("select p.capitalmoney from p_capital p where p.userid=#{userid}")
    Capital queryCapital(@Param("capital") Capital capital, @Param("userid") Integer userid);

    @Select("select p.capitalname,p.capitalmoney from p_capital p where p.userid=#{userid}")
    List<Capital> queryReceipt(@Param("capital")Capital capital, @Param("userid")Integer userid);


}
