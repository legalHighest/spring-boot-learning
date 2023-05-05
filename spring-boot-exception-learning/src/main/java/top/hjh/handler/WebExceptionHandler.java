package top.hjh.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.hjh.enums.CustomExceptionType;
import top.hjh.exception.CustomException;
import top.hjh.util.AjaxResponse;

import java.lang.reflect.Field;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 14 42
 **/

@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse handleException1(CustomException e){
        if (e.getCode()== CustomExceptionType.SYSTEM_ERROR.getCode()){
            log.info(CustomExceptionType.SYSTEM_ERROR.getDesc());
        }

        return AjaxResponse.error(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public  AjaxResponse handeleBindException(MethodArgumentNotValidException ex){
        FieldError fieldError=ex.getBindingResult().getFieldError();
        assert  fieldError !=null;
        return  AjaxResponse.error(new CustomException(CustomExceptionType.PARAM_ERROR,fieldError.getDefaultMessage()));

    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public  AjaxResponse handleBindException(BindException ex){
        FieldError fieldError=ex.getBindingResult().getFieldError();
        assert fieldError!=null;

        return AjaxResponse.error(new CustomException(CustomExceptionType.PARAM_ERROR,fieldError.getDefaultMessage()));
    }

}
