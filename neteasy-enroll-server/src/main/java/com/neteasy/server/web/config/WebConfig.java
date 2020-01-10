package com.neteasy.server.web.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.neteasy.server.web.security.filter.AccessControlFilter;
import com.neteasy.server.web.security.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.DispatcherType;
import java.util.List;

/**
 * 项目配置
 *
 * @author Ivan
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter;

    /**
     * 开放swagger2静态资源过滤
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    /**
     * 配置消息转换器
     *
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // FastJson消息转换器
        converters.add(fastJsonHttpMessageConverter);
    }

    /**
     * 跨域处理
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean accessFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new AccessControlFilter());
        registration.addUrlPatterns("/*");
        registration.setName("accessFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 登陆拦截
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 登录过滤
        registry.addInterceptor(authorizationInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    @Bean
    public AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    /**
     * 注册过滤器
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean testFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new RequestReadFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("requestReadFilter");
//        registration.setOrder(1);
//        return registration;
//    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        // 登录过滤
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//    @Bean
//    public AuthenticationInterceptor authenticationInterceptor() {
//        return new AuthenticationInterceptor();
//    }

}
