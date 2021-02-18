package com.servlet.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("UTF-8");
        String path = request.getRequestURI();
        if(path.contains("add-student")) {//TODO: rewrite add user roles
            if (((HttpServletRequest) servletRequest).getSession().getAttribute("faculty") != null) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                servletResponse.getWriter().append("AccessDenied");
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
