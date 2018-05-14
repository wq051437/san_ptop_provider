package com.jk.service.impl;

import com.jk.dao.UserDao;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2018/5/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void queryUser() {
        userDao.queryUser();
    }
}
