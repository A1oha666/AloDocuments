package org.example.itheimabigevent.service;

import org.example.itheimabigevent.pojo.User;

public interface UserService {
    User findByUserName(String username);


    void register(String username, String password);

}
