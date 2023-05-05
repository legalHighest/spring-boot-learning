package top.hjh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import top.hjh.domain.Certificate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 17 13 39
 **/
@Slf4j
@Controller
public class SseController {
//返回一个响应事件ResponseBodyEmitter
    @RequestMapping(value = "/sse/msg",method = RequestMethod.GET,produces = "text/event-stream;charset=UTF-8")
public ResponseBodyEmitter  pushMsg()   {
        SseEmitter emitter=new SseEmitter(2L);
//        try {
//            Thread.sleep(2000);
//        } catch (
//                InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        log.info("emitter push msg....");


//    Certificate certifica=new Certificate();

        double price=Math.random()*1000+1;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String msg= format.format(date)+"股票价格:"+price;
//        String a="fdafdasfdasf";
//        List<String> list=List.of("aaa","bbb","ccc");
        try {

            emitter.send(msg, MediaType.TEXT_EVENT_STREAM);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return  emitter;
    }
}
