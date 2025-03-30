package org.example.itheimabigevent.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.itheimabigevent.utils.JwtUtil;
import org.example.itheimabigevent.utils.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(final HttpServletRequest request, HttpServletResponse response, final Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        log.info("token: {}", token);
        //验证token
        try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            //http 响应状态码为401
            response.setStatus(401);
            return false;
        }
    }

}
