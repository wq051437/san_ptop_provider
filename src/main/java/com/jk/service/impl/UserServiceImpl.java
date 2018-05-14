package com.jk.service.impl;

import com.jk.dao.UserDao;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2018/5/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserBean> queryUser() {
        System.out.println(123);
        return userDao.queryUser();
    }
}
