package top.hjh.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.hjh.enums.CustomExceptionType;
import top.hjh.exception.CustomException;

import java.lang.reflect.Method;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 19 48
 **/

@Aspect
@Component
public class AuthAspect {

    private HttpServletRequest getHttpServletRequest(){
        RequestAttributes requestAttributes=RequestContextHolder.getRequestAttributes();
       ServletRequestAttributes attributes=(ServletRequestAttributes) requestAttributes;
      assert  attributes!=null;
      return  attributes.getRequest();
    }

    @Around("@annotation(top.hjh.auth.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint point) throws Throwable {
        //获取请求对象
        HttpServletRequest request = getHttpServletRequest();
        //获取请求头
        String token =request.getHeader("Authorization");
        if(token==null){
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }

        //获取@CheckAuth注解里的值
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        CheckAuth annotation = method.getAnnotation(CheckAuth.class);
        String value=annotation.value();
        if(!(value.equals(token))){
            throw  new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }
        return point.proceed();
    }
}


