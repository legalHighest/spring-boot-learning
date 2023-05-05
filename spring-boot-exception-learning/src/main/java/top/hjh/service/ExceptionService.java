package top.hjh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.hjh.consts.MsgConsts;
import top.hjh.domain.Article;
import top.hjh.enums.CustomExceptionType;
import top.hjh.exception.CustomException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 14 39
 **/
@Service
@Slf4j
public class ExceptionService {

    public  void authError(){
        throw  new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
    }

    public Article getArticle(int id){
        log.info(String.valueOf(id));
        if (id<=0){
            log.info("傻逼去死");
            throw  new CustomException(CustomExceptionType.PARAM_ERROR);
        }
        return findArticleById(id);
    }

  public  Article findArticleById(int id){
        List<Article> articleList=List.of(
                new Article(1,"Spring 从入门到精通","白金","111@qq.com", LocalDateTime.of(2023,3,30,12,12,12)),
                new Article(2,"Spring Boot 从入门到精通","2224@qq.com","大神",LocalDateTime.of(2023,3,30,12,12,12)),
                new Article(3,"Spring Cloud 从入门到精通","2222@qq.com","高级",LocalDateTime.of(2023,3,30,12,12,12))
        );
        Article article1=articleList.stream().filter(article -> article.getId()==id).toList().get(0);
        log.info(article1.getTitle()+"天天向上");
        return  articleList.stream().filter(article -> article.getId()==id).toList().get(0);
  }
}
