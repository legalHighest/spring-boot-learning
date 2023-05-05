package top.hjh.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 18 16 30
 **/
@RestController
@Tag(name="HellowController",description = "测试接口")
public class HellowController {

    @GetMapping("hello")
    @Operation(summary = "hello",description = "测试接口的test方法")
    public  String test(){
        return  "hello springdoc";
    }
    @GetMapping("hello1")
    @Operation(summary = "hello",description = "测试接口的test方法")
    public  String test1(){
        return  "hello springdoc1";
    }

}
