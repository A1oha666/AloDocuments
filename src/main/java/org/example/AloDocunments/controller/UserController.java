package org.example.AloDocunments.controller;

import jakarta.validation.constraints.Pattern;
import org.example.AloDocunments.pojo.Result;
import org.example.AloDocunments.pojo.User;
import org.example.AloDocunments.service.UserService;
import org.example.AloDocunments.utils.JwtUtil;
import org.example.AloDocunments.utils.MD5Util;
import org.example.AloDocunments.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/){
//        //根据用户名查询用户
//        Map<String,Object> map=JwtUtil.parseToken(token);
        Map<String,Object> map = ThreadLocalUtil.get();
        String username=(String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //1.校验参数
        Map<String,Object> map = ThreadLocalUtil.get();
        String username=(String) map.get("username");
        String oldPwd=params.get("old_pwd");
        String newPwd=params.get("new_pwd");
        String rePwd =params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) ||!StringUtils.hasLength(newPwd) ||!StringUtils.hasLength(rePwd)){
            return Result.error("密码不能为空!");
        }

        if (!MD5Util.getMD5String(oldPwd).equals(userService.findByUserName(username).getPassword())){
            return Result.error("原密码不正确");
        }

        if(newPwd.equals(rePwd)){
            userService.updatePwd(newPwd);
        }
        return Result.success();
    }



}
