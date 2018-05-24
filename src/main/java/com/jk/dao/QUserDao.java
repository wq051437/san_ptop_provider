package com.jk.dao;

import com.jk.model.QUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by new鹏 on 2018/5/18.
 */
@Mapper
public interface QUserDao {
    @Select(" SELECT     *    FROM    p_user WHERE   p_user.userphone=#{userphone}   AND     p_user.userpass= #{userpass}    ")
    QUserBean login(QUserBean qUserBean);
    @Select("   update    p_user  set   p_user.logintime=#{q}        where   p_user.userid=#{userid}   ")
    void updatedate(@Param("userid") Integer userid,@Param("q") String q);
}
