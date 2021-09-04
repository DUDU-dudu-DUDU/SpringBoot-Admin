package com.wu.admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 @Order(value = Ordered.HIGHEST_PRECEDENCE)// 数字越小优先级越高
@Component
public class CustomeHandleerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object o, Exception e) {
        try {
            response.sendError(511, "我喜欢的错误");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new ModelAndView();
    }
}
*/
