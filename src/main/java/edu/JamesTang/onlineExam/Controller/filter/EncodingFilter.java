package edu.JamesTang.onlineExam.Controller.filter;



import javax.servlet.*;
import java.io.IOException;

/**
 * @author JamesTang
 * @date 2020/12/22 19:45
 */

public class EncodingFilter implements Filter {

    public EncodingFilter(){

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
