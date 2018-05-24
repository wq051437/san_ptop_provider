package com.jk.dao;

import com.jk.model.GrManagerBean;
import com.jk.model.QUserBean;
import com.jk.model.QyManagerBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ASUS on 2018/5/16.
 */
@Mapper
public interface WqAccountManageDao {

    //查询账户信息
    long queryAccountManageCount(@Param("qUserBean")QUserBean qUserBean,@Param("registerdatestary")String registerdatestary,@Param("registerdateend")String registerdateend);
    List<QUserBean> queryAccountManagePage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("qUserBean")QUserBean qUserBean,@Param("registerdatestary")String registerdatestary,@Param("registerdateend")String registerdateend);

    //导出账户信息
    List<QUserBean> queryAccount();

    //锁定
    void lockAccount(QUserBean qUserBean);

    //解锁
    void deblockingAccount(QUserBean qUserBean);

    //获取用户名称
    QUserBean backShowUsername(Integer userid);

    //拉黑
    void blockAccount(QUserBean qUserBean);

    //取消拉黑
    void qxBlockAccount(QUserBean qUserBean);

    //添加个人信息
    List queryGrUsersf(QUserBean qUserBean);
    void addGrUser(QUserBean qUserBean);
    int queryQUserId(QUserBean qUserBean);
    void addGrUsers(GrManagerBean grManagerBean);

    //新增企业信息
    List queryQyUsersf(QUserBean qUserBean);
    void addQyUser(QUserBean qUserBean);
    int queryQyUserId(QUserBean qUserBean);
    void addQyUsers(QyManagerBean qyManagerBean);
}
