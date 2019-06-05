package com.javaliu.modules.i18n;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <br> 类名：TimeZoneInterceptor
 * <br> 描述：
 * <br> 作者：sontek
 * <br> 创建：2018年06月13日
 * <br> 版本：V1.0.0
 */
public class TimeZoneInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TimeZone timeZone = RequestContextUtils.getTimeZone(request);
        Locale locale = RequestContextUtils.getLocale(request);
        System.out.println("当前本地是：" + locale);
        System.out.println("当前时区是：" + timeZone);
        if (timeZone == null) {
            System.out.println("Forwarding to js to get timezone offset");
            String uri = request.getRequestURI();
            System.out.println("requestedUrl: " + uri);
            request.setAttribute("requestedUrl", uri);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/timeZone/tzHandler");
            dispatcher.forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
