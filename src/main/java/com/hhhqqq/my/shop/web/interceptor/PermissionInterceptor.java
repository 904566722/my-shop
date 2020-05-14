package com.hhhqqq.my.shop.web.interceptor;

import com.hhhqqq.my.shop.commons.constant.ConstantUtils;
import com.hhhqqq.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName PermissionInterceptor
 * @Description TODO
 * @Author HHQ
 * @Date 2020/5/14 21:20
 * @Version 1.0
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 如果用户登录了，以login结尾的请求 跳转到首页
        if (modelAndView.getViewName().endsWith("login")) {
            User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

            if (user != null) {
                httpServletResponse.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
