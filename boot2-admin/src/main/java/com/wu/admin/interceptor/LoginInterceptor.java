package com.wu.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1.配置拦截器  拦截哪些请求
// 2.把这些配置放在容器中

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是: {}", requestURI);

        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return true;
        }else {
            // 未登录 跳转到登录页
            // session.setAttribute("msg", "请先登录亲~");  拦截器重定向无法取出session
            // response.sendRedirect("/");
            request.setAttribute("msg", "请先登录亲~");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }

    }

    /**
     * 目标方法执行后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
