package top.hjh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 16 06
 **/
@Slf4j
@Service
public class TestService {

    @RequestMapping("/test?${i}")
    public String test(){
        log.info("testService");
        System.out.println();
        return "test";
    }
}
