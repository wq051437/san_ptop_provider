package com.jk.service.impl;

import com.jk.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2018/5/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void queryUser() {
        System.out.println(123);
    }
}
