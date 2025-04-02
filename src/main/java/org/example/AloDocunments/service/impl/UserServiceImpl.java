package org.example.AloDocunments.service.impl;

import org.example.AloDocunments.mapper.UserMapper;
import org.example.AloDocunments.pojo.User;
import org.example.AloDocunments.service.UserService;
import org.example.AloDocunments.utils.MD5Util;
import org.example.AloDocunments.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl){
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id =(Integer)map.get("id");//token被储存在ThreadLocal中，token包含有id和username，可以从中get到id
        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id =(Integer)map.get("id");
        userMapper.updatePwd(MD5Util.getMD5String(newPwd),id);
    }

}
