package org.example.AloDocuments.service;

import org.example.AloDocuments.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

    void update(User user);//更新

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
