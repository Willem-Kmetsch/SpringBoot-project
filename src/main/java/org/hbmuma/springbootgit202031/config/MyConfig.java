package org.hbmuma.springbootgit202031.config;

import org.hbmuma.springbootgit202031.component.LoginHandlerInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptors())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login");
    }
}
