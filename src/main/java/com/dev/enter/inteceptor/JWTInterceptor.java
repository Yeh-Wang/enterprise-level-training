package com.dev.enter.inteceptor;

import com.dev.enter.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : Yaxin-Wang
 * @date : 2023/3/1
 */
@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//这里一定不要忘了设置OPTIONS这个跨域请求，第一个请求一般不带token，然后会发起第二次请求带token
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
//            System.out.println("跨域的第一次 OPTIONS 放行");
            return true;
        }
//        System.out.println("拦截了 manage");
//        从请求头中获取token
        String token = request.getHeader("token");
//        判断token是否正确
        if(token == null || token.equals("token")){
            return false;
        }
        System.out.println("1111111111111111111111111111111111111111111111");
        System.out.println(token);
//        解析token
        if(!JWTUtils.verify(token)){
            return false;
        }
        return true;
    }
}
