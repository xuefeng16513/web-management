package com.zidong.tlians_web_management.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zidong.tlians_web_management.pojo.Result;
import com.zidong.tlians_web_management.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源运行前运行，返回true则放行
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response , Object handler) throws Exception {
        System.out.println("preHandle");
//        return HandlerInterceptor.super.preHandle (request , response , handler);
        String jwt = request.getHeader("token");
        if (jwt != null && !jwt.isEmpty ()) {
            try {
                JwtUtils.parseJWT(jwt);
            } catch (Exception e) {//jwt解析失败
                e.printStackTrace();
                log.info("解析令牌失败, 返回未登录错误信息");
                Result error = Result.error("NOT_LOGIN");
                //手动转换 对象--json --------> 阿里巴巴fastJSON
                String notLogin = JSONObject.toJSONString(error);
                response.getWriter().write(notLogin);
                return false;
            }
        } else {
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        log.info("令牌合法，放行");
        return true;
    }

    @Override//目标资源运行后运行
    public void postHandle(HttpServletRequest request , HttpServletResponse response , Object handler , ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        // HandlerInterceptor.super.postHandle (request , response , handler , modelAndView);
    }

    @Override//视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request , HttpServletResponse response , Object handler , Exception ex) throws Exception {
        System.out.println("afterCompletion");
        // HandlerInterceptor.super.afterCompletion (request , response , handler , ex);
    }
}
