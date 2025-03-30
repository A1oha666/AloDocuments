package org.example.itheimabigevent.controller;

import jakarta.validation.constraints.Pattern;
import org.example.itheimabigevent.DTO.UserRegisterDTO;
import org.example.itheimabigevent.pojo.Result;
import org.example.itheimabigevent.pojo.User;
import org.example.itheimabigevent.service.UserService;
import org.example.itheimabigevent.utils.JwtUtil;
import org.example.itheimabigevent.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    //数据范围5~16 数据范围5~16 数据范围5~16 数据范围5~16 数据范围5~16
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {

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

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        User LoginUser = userService.findByUserName(username);
        if(LoginUser==null) {
            return Result.error("用户名不存在！");
        }
        if(LoginUser.getPassword().equals(MD5Util.getMD5String(password))) {

            Map<String, Object> claims=new HashMap<>();
            claims.put("id",LoginUser.getId());
            claims.put("username",LoginUser.getUsername());
            String token =JwtUtil.genToken(claims);
            return Result.success(token);
        }
         return Result.error("密码错误！");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token){
        //根据用户名查询用户
        Map<String,Object> map=JwtUtil.parseToken(token);
        String username=(String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }



}
