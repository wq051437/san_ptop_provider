package com.jk.dao;

import com.jk.model.GrManagerBean;
import com.jk.model.QUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2018/5/21.
 */
@Mapper
public interface WqPeopleNewsDao {

    //查询个人信息
    long queryPeopleNewsCount(@Param("qUserBean")QUserBean qUserBean,@Param("registerdatestary")String registerdatestary,@Param("registerdateend")String registerdateend, @Param("grname")String grname);
    List queryPeopleNewsPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("qUserBean")QUserBean qUserBean,@Param("registerdatestary")String registerdatestary, @Param("registerdateend")String registerdateend, @Param("grname")String grname);

    //回显个人信息
    QUserBean backShowPeopleNews(Integer grid);
    GrManagerBean backShowPeopleNewss(Integer grid);

    //修改个人信息
    void updateGrUser(QUserBean qUserBean);

    //导出个人信息
    List<GrManagerBean> ExceportPeopleNews();

    List<QUserBean> ExceportAccount();
}
