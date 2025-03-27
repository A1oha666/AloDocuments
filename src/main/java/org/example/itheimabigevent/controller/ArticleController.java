package org.example.itheimabigevent.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.itheimabigevent.pojo.Result;
import org.example.itheimabigevent.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    //根据接口文档 请求头
    public Result<String> list(){
//        try {
//            Map<String,Object> claims = JwtUtil.parseToken(token);
//            return Result.success("所有的文章数据");
//        }catch (Exception e) {
//            //http 响应状态码为401
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("所有的文章数据");
    }
}
