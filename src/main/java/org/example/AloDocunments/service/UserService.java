package org.example.AloDocunments.service;

import org.example.AloDocunments.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

    void update(User user);//更新

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
