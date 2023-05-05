package top.hjh.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 22 08
 **/

@RestController
public class TestListenerController {
    @GetMapping("/hello")
    public  void hello(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute("author","hjhj");
        request.setAttribute("author","张三");
        request.removeAttribute("author");
    }
}
