package com.jk.dao;

import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ASUS on 2018/5/14.
 */
@Mapper
public interface UserDao {
    @Select("select * from t_user")
    List<UserBean> queryUser();
}
