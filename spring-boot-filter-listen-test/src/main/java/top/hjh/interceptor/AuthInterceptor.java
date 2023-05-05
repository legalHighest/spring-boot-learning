package top.hjh.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 16 11
 **/
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token=request.getHeader("Authorization");
        log.info(token+"dsfsdfsdfsdf");
        if (token!=null){
            if ("Admin123".equals(token)){
               log.info("拦截器启动");
                return  true;
            }else {
               log.info("拦截器不启动");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }else {
         log.info("拦截器不启动");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
