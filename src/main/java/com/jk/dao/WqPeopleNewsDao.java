package com.jk.dao;

import com.jk.model.CapitalBean;
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

    CapitalBean selectCapital(Integer userid);

    //查询个人基本信息
    QUserBean selectJbPeopleNews(Integer grid);

    GrManagerBean selectJbPeopleNewss(Integer grid);

    GrManagerBean selectJbPeopleNewss1(Integer userid);

    QUserBean selectJbPeopleNews1(Integer userid);

    //查询个人学历信息
    long queryGrEducationCount(@Param("userid") Integer userid);

    List queryGrEducationPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("userid")Integer userid);

    //查询个人工作信息
    long queryGrWorkCount(@Param("userid")Integer userid);

    List queryGrWorkPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("userid")Integer userid);

    //查询个人房产信息
    long queryGrRoomCount(@Param("userid")Integer userid);

    List queryGrRoomPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("userid")Integer userid);

    //查询个人车产信息
    long queryGrCarCount(@Param("userid")Integer userid);

    List queryGrCarPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("userid")Integer userid);

    //查询个人借款记录
    long queryGrLoanRecordCount(@Param("userid")Integer userid, @Param("loantitle")String loantitle, @Param("applyloandatestary")String applyloandatestary, @Param("applyloandateend")String applyloandateend, @Param("loanstate")Integer loanstate);

    List queryGrLoanRecordPage(@Param("offset") Integer offset,@Param("limit")Integer limit, @Param("userid")Integer userid, @Param("loantitle")String loantitle, @Param("applyloandatestary")String applyloandatestary, @Param("applyloandateend")String applyloandateend, @Param("loanstate")Integer loanstate);
}
