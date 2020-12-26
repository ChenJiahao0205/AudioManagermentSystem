package pers.chenjiahao.audiomgs.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetSessionUtil {
    private static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    public static HttpSession getSession(){
        HttpServletRequest request = GetSessionUtil.getRequest();
        HttpSession session = request.getSession();
        return session;
    }
}
