package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class IndexFilter implements Filter {

    public void destroy(){
    }

    public void init(FilterConfig filterConfig) throws ServletException{
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("come in IndexFilter");
        chain.doFilter(request,response);
    }
}
