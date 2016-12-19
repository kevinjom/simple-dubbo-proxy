package com.github.kevinjom;

import com.github.kevinjom.authentication.AuthFilter;
import com.github.kevinjom.authentication.AuthService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public FilterRegistrationBean authFilter(AuthService authService) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthFilter(authService));
        registration.addUrlPatterns("/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }

}