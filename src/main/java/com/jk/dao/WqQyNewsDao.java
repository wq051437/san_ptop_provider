package com.jk.dao;

import com.jk.model.QUserBean;
import com.jk.model.QyManagerBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ASUS on 2018/5/22.
 */
public interface WqQyNewsDao {
    //查询企业信息
    long queryQyNewsCount(@Param("qUserBean")QUserBean qUserBean, @Param("registerdatestary")String registerdatestary, @Param("registerdateend")String registerdateend, @Param("qyname")String qyname, @Param("lxrname")String lxrname, @Param("sfyxinvest")String sfyxinvest);
    List queryQyNewsPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("qUserBean")QUserBean qUserBean, @Param("registerdatestary")String registerdatestary, @Param("registerdateend")String registerdateend, @Param("qyname")String qyname, @Param("lxrname")String lxrname, @Param("sfyxinvest")String sfyxinvest);

    //导出企业信息
    List<QyManagerBean> ExceportQy();
    List<QUserBean> ExceportAccount();

    //回显企业信息
    QUserBean backShowQy(Integer qyid);

    QyManagerBean backShowQys(Integer qyid);

    //修改企业信息
    void updateQyUser(QyManagerBean qyManagerBean);
}
