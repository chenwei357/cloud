package com.will.webmvc.config;

import com.will.webmvc.message.PropertiesPersonHttpMessageConverter;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WEB MVC配置
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer, ErrorPageRegistrar {

    //@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(0, new MappingJackson2XmlHttpMessageConverter());
//        converters.add(0, new PropertiesPersonHttpMessageConverter());
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultHandlerInterceptor());
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    }
}
