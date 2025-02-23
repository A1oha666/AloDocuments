package org.example.itheimabigevent.controller;

import org.example.itheimabigevent.pojo.Result;
import org.example.itheimabigevent.pojo.User;
import org.example.itheimabigevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username,String password) {

        //search
        User u = userService.findByUserName(username);
        if(u==null) {
            //register
            userService.register(username,password);
            return Result.success();
        }else{
            //repeat
            return Result.error("用户名已被占用");
        }

    }
}
