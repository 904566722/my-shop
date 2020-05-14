package com.hhhqqq.my.shop.web.interceptor;

import com.hhhqqq.my.shop.commons.constant.ConstantUtils;
import com.hhhqqq.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author HHQ
 * @Date 2020/5/14 21:05
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User)httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        // 未登录 - 登录拦截
        if (user == null) {
            httpServletResponse.sendRedirect("/login");
        }

        // 登录 - 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
