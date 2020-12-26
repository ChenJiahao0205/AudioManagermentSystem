package pers.chenjiahao.audiomgs.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlPageUtil {

    public static void alert(String message){
        HttpServletResponse resp = getResponse();
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('"+ message +"');");
            out.println("window.history.go(-1);");
            out.println("window.location.reload();");
            System.out.println("经过了reload()");
            out.println("</script>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }
    public static void pageRefresh(){
        HttpServletResponse resp = getResponse();
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            out.flush();
            out.println("<script>");
            out.println("location.reload()");
            out.println("</script>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
