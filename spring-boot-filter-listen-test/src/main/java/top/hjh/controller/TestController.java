package top.hjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 16 01
 **/

@Controller
public class TestController {
    @GetMapping("/index")
    public  String test(Model model){
        model.addAttribute("msg","Spring 拦截器学习");
        return  "index";
    }

    @GetMapping("/login")
    @ResponseBody
    public  String getHello(){
        return "访问 /api/hello 接口返回数据";
    }

}
