package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	
    private static final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
    private List<Integer> errorCodeList = Arrays.asList(404, 403, 500,405);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") != null){
            if (errorCodeList.contains(httpServletResponse.getStatus())) {
            //捕获异常后进行重定向，controller对应的requestMapping为/error/{code}
            httpServletResponse.sendRedirect("/error/" + "404");
            return false;
            }else{
                return true;
            }
        }else{
            String url = "/";
            httpServletResponse.sendRedirect(url);
            return false;
        }





    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
