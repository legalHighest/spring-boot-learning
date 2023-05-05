package top.hjh.interceptor;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.hjh.service.TestService;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 16 03
 **/
@Slf4j
@Component
public class TestInterceptor implements HandlerInterceptor {
    @Resource
    private TestService testService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandele：请求接口前调用");
        log.info(testService.test());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       log.info("postHandle: 请求后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterComletion：请求调用完成后的回调方法，即在视图渲染完成后调用");
    }
}
