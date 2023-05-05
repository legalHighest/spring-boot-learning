package top.hjh.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import top.hjh.auth.CheckAuth;
import top.hjh.domain.Article;
import top.hjh.service.ExceptionService;
import top.hjh.util.AjaxResponse;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 14 48
 **/
@RestController
@RequestMapping("/api")
public class CustomController {

    @Resource
    private ExceptionService exceptionService;


    @GetMapping("/articles/{id}")
    @CheckAuth(value = "hjh")
    public AjaxResponse getArticle(@PathVariable("id") int id){
        return AjaxResponse.sucess((exceptionService.getArticle(id)));
    }

    @PostMapping("/articles")
    public  AjaxResponse saveArticle(@Valid @RequestBody Article article){
        return  AjaxResponse.sucess(article);
    }


}
