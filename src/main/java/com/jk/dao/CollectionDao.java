package com.jk.dao;

import com.jk.model.CollectionBean;
import com.jk.model.Online;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by new鹏 on 2018/5/29.
 */
@Mapper
public interface CollectionDao {

    void addunclinelist(CollectionBean collectionBean);

    /**
     * 查询个数
     * @param loanid
     * @return
     */
    long querycollectionCount(Integer loanid);

    /**
     * 查询数据
     * @param offset
     * @param limit
     * @param loanid
     * @return
     */
    List querycollectionlist(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("loanid") Integer loanid);
    List addchaxuqiu(Integer userid);

    void addonlinelist(Online online);

    void addonclinelist(Online online);

    /**
     * 查询线上
     * @param offset
     * @param limit
     * @param username
     * @param collectiontype
     * @param starttimess
     * @param endtimess
     * @return
     */
    List queryonlinelist(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("username") String username, @Param("collectiontype") String collectiontype, @Param("starttimess") String starttimess, @Param("endtimess") String endtimess);
    long queryonlineCount(@Param("username") String username, @Param("collectiontype") String collectiontype, @Param("starttimess") String starttimess, @Param("endtimess") String endtimess);

    /**
     * 查询线下
     * @param offset
     * @param limit
     * @param username
     * @param collectiontype
     * @param starttimess
     * @param endtimess
     * @return
     */
    List queryunderlinelist(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("username") String username, @Param("collectiontype") String collectiontype, @Param("starttimess") String starttimess, @Param("endtimess") String endtimess);
    long queryunderlineCount(@Param("username") String username, @Param("collectiontype") String collectiontype, @Param("starttimess") String starttimess, @Param("endtimess") String endtimess);
    /**
     * 查询催款详情线下
     * @param collectionid
     * @return
     */
    List querydetailsUnderline(Integer collectionid);

    /**
     * 查询催款详情线上
     * @param onlineid
     * @return
     */
    List querydetailsonline(Integer onlineid);


}
