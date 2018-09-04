package com.wpt.risk.interceptor;


import com.wpt.risk.base.utils.Constants;
import com.wpt.risk.dal.pojo.WUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestUrl = httpServletRequest.getRequestURL().toString();
        String servletPath = httpServletRequest.getServletPath();
        String path = StringUtils.substringBefore(requestUrl, servletPath);
        Object object = WebUtils.getSessionAttribute(httpServletRequest, Constants.CUR_USER);
        if (object == null || !(object instanceof WUser)) {
            String queryString = httpServletRequest.getQueryString();
            StringBuffer requestURL = httpServletRequest.getRequestURL();
            String realUrl;
            if (queryString == null) {
                realUrl = requestURL.toString();
            } else {
                realUrl = requestURL.append('?').append(queryString).toString();
            }

            String redirectUrl = URLEncoder.encode(realUrl, "UTF-8");
            if (redirectUrl.startsWith("/") || redirectUrl.startsWith(path + "/")) {
                redirectUrl = path + "/";
            }
            httpServletResponse.sendRedirect(path + "/login?redirectURL=" + redirectUrl);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}