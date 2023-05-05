package top.hjh.interceptor;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 16 10
 **/
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    private  final  String[]excludePath={"/*.css","/index","/hello"};

    @Resource
    private  TestInterceptor testInterceptor;



    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(testInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
