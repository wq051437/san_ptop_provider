package com.jk.dao;

import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by ASUS on 2018/5/14.
 */
@Mapper
public interface UserDao {
    @Select(" select  *  from     t_user    where   t_user.userphone=#{userphone}   and    t_user.userpass=#{userpass}")
    UserBean login(UserBean userBean);
    @Update(" update t_user set userpass= #{passwo3}  where  userid= #{userid}")
    void updatemima(@Param("userid") Integer userid, @Param("passwo3") String passwo3);
    @Select("select  count(*)  from    p_user   WHERE   p_user.registerdate like #{format}")
    Integer querysaverenshu(String format);
    @Select("select  count(*)  from    p_user")
    Integer queryzongrenshu();
    @Select("select  count(*)  from    p_user   WHERE   p_user.logintime like #{format}")
    Integer queryloginrenshu(String format);
    @Select("   select  *  from     t_user    where   t_user.userphone=#{phone}   ")
    UserBean   addpanduanphone(String phone);
    @Update(" update t_user set userpass= #{userpass}  where  userid= #{userid}   ")
    void updateusermima(@Param("userid") Integer userid,@Param("userpass") String userpass);

    @Select("select count(*) from t_invest i where i.lendstate=2")
    Integer querydsh();

    @Select("select count(*) from t_invest i where i.lendstate=2")
    Integer querydcl();

    @Select("select count(*) from t_invest i where i.lendstate=1")
    Integer querydfb();
}
