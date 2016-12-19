package com.github.kevinjom.authentication;

import org.springframework.http.HttpStatus;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    private final AuthService authService;

    public AuthFilter(AuthService authService) {
        this.authService = authService;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String authInfo = req.getHeader("Authentication");
        if (authService.auth(authInfo)) {
            chain.doFilter(request, response);
        }else{
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());
            resp.getWriter().write("Unauthorized");
        }
    }

    @Override
    public void destroy() {

    }
}
