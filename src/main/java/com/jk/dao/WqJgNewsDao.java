package com.jk.dao;

import com.jk.model.JgManagerBean;
import com.jk.model.QUserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ASUS on 2018/5/22.
 */
public interface WqJgNewsDao {
    //查询机构信息
    long queryJgNewsCount(@Param("qUserBean")QUserBean qUserBean, @Param("registerdatestary")String registerdatestary, @Param("registerdateend")String registerdateend, @Param("jgname")String jgname, @Param("lxrname")String lxrname, @Param("sfyxinvest")String sfyxinvest, @Param("sfyxbuy")String sfyxbuy);
    List queryJgNewsPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("qUserBean")QUserBean qUserBean, @Param("registerdatestary")String registerdatestary, @Param("registerdateend")String registerdateend, @Param("jgname")String jgname, @Param("lxrname")String lxrname, @Param("sfyxinvest")String sfyxinvest, @Param("sfyxbuy")String sfyxbuy);

    //导出机构信息
    List<QUserBean> ExceportAccount();
    List<JgManagerBean> ExceportJg();
}
