package com.jk.dao;

import com.jk.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by new鹏 on 2018/5/18.
 */
@Mapper
public interface QUserDao {
    @Select(" SELECT     *    FROM    p_user WHERE   p_user.username=#{username}   AND     p_user.userpass= #{userpass}")
    QUserBean login(QUserBean qUserBean);
    @Select("   update    p_user  set   p_user.logintime=#{q}        where   p_user.userid=#{userid}   ")
    void updatedate(@Param("userid") Integer userid,@Param("q") String q);

    List querygerenlist(@Param("userid") Integer userid);
    List querygerenlist2(Integer userid);
    @Update("  update    p_user  set   p_user.userpass=#{userpass}        where   p_user.userid=#{userid}  ")
    void updatemima(@Param("userid") Integer userid,@Param("userpass") String userpass);
    @Update("  update    p_user  set   p_user.jiaoyimima=#{jiaoyi}        where   p_user.userid=#{userid}  ")
    void updatejiaoyimima(@Param("jiaoyi") String jiaoyi,@Param("userid") Integer userid);
    @Update("   update    p_gr  set  p_gr.grphoto=#{fileUrl}     where p_gr.userid=#{userid}  ")
    void addphoto(@Param("fileUrl") String fileUrl,@Param("userid") Integer userid);


    String addphotolist(String qname);
    long queryeducationlistCount(Integer userid);
    List queryeducationlist(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("userid") Integer userid);

    void addeducationlist(EducationBean educationBean);

    List queryupdatelist(Integer stuid);

    void updateeducationlist(EducationBean educationBean);

    /***
     * 查询工作
     * @param userid
     * @return
     */
    long queryworklistCount(Integer userid);
    List queryworklist(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("userid") Integer userid);

    /**
     * 查询地区
     * @return
     */
    List queryaddresslist();

    /***
     * 添加工作经历
     * @param workBean
     */
    void addworklist(WorkBean workBean);

    /**
     * 查询修改工作的数据
     * @param workid
     * @return
     */
    List queryupdateworklist(Integer workid);

    /**
     * 修改工作信息
     * @param workBean
     */
    void updateworklist(WorkBean workBean);

    /**
     * 查询房产信息
     * @param userid
     * @return
     */
    long queryroomlistCount(Integer userid);
    List queryroomlist(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("userid") Integer userid);

    /**
     * 新增房产
     * @param roomBean
     */
    void addroomlist(RoomBean roomBean);

    /**
     * 查询修改的房产信息
     * @param roomid
     * @return
     */
    List queryupdateroomlist(Integer roomid);

    /**
     * 修改房产信息
     * @param roomBean
     */
    void updateroomlist(RoomBean roomBean);

    /**
     * 查询车产
     * @param userid
     * @return
     */
    long querycarlistCount(Integer userid);
    List querycarlist(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("userid") Integer userid);

    /**
     * 添加车产
     * @param carBean
     */
    void addcarlist(CarBean carBean);

    /**
     * 查询修改数据
     * @param carid
     * @return
     */
    List queryupdatecarlist(Integer carid);

    /**
     * 修改数据
     * @param carBean
     */
    void updatecarlist(CarBean carBean);

    /**
     * 查询手机号是否存在
     * @param phone
     * @return
     */
    QUserBean addpanduanphone(String phone);

    /**
     * 新增用户
     * @param qUserBean
     */
    void addpuserlist(QUserBean qUserBean);
}
