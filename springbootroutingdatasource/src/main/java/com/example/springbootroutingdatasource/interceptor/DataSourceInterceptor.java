package com.example.springbootroutingdatasource.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataSourceInterceptor implements HandlerInterceptor {
    // Request:
    // /publisher/list
    // /advertiser/list
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String contextPath = request.getServletContext().getContextPath();

        // /SomeContextPath/publisher
        String prefixPublisher = contextPath + "/publisher";

        // /SomeContextPath/advertiser
        String prefixAdvertiser = contextPath + "/advertiser";

        // /SomeContextPath/publisher/dashboard
        // /SomeContextPath/advertiser/dashboard

        String uri = request.getRequestURI();
        System.out.println("URI: " + uri);

        if (uri.startsWith(prefixPublisher)) {
            request.setAttribute("keyDS", "PUBLISHER_DS");
        }
        else if (uri.startsWith(prefixAdvertiser)) {
            request.setAttribute("keyDS", "ADVERTISER_DS");
        }

        return true;
    }
}
