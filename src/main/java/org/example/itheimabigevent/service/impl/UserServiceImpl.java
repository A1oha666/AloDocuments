package org.example.itheimabigevent.service.impl;

import org.example.itheimabigevent.mapper.UserMapper;
import org.example.itheimabigevent.pojo.User;
import org.example.itheimabigevent.service.UserService;
import org.example.itheimabigevent.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //加密处理
        String md5String=MD5Util.getMD5String(password);
        userMapper.add(username,md5String);
    }
}
