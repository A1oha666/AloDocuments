package org.example.itheimabigevent.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.itheimabigevent.mapper.UserMapper;
import org.example.itheimabigevent.pojo.Article;
import org.example.itheimabigevent.pojo.Result;
import org.example.itheimabigevent.utils.JwtUtil;
import org.example.itheimabigevent.utils.ThreadLocalUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    //根据接口文档 请求头
    public Result<String> list(){
        /*
        try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            return Result.success("所有的文章数据");
        }catch (Exception e) {
            //http 响应状态码为401
            response.setStatus(401);
            return Result.error("未登录");
        }
      */
        return Result.success("所有的文章数据");
    }
}
