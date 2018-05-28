package com.jk.dao;

import com.jk.model.QUserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by new鹏 on 2018/5/18.
 */
@Mapper
public interface QUserDao {
    @Select(" SELECT     *    FROM    p_user WHERE   p_user.username=#{username}   AND     p_user.userpass= #{userpass}    ")
    QUserBean login(QUserBean qUserBean);
    @Select("   update    p_user  set   p_user.logintime=#{q}        where   p_user.userid=#{userid}   ")
    void updatedate(@Param("userid") Integer userid,@Param("q") String q);


    List querygerenlist(@Param("userid") Integer userid);
    @Update("  update    p_user  set   p_user.userpass=#{userpass}        where   p_user.userid=#{userid}  ")
    void updatemima(@Param("userid") Integer userid,@Param("userpass") String userpass);
    @Update("  update    p_user  set   p_user.jiaoyimima=#{jiaoyi}        where   p_user.userid=#{userid}  ")
    void updatejiaoyimima(@Param("jiaoyi") String jiaoyi,@Param("userid") Integer userid);
    @Update("   update    p_gr  set  p_gr.grphoto=#{fileUrl}     where p_gr.userid=#{userid}  ")
    void addphoto(@Param("fileUrl") String fileUrl,@Param("userid") Integer userid);


    String addphotolist(String qname);
}
