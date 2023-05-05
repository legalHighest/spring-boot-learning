package top.hjh.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 18 15 39
 **/
@Component
public class ApplicationInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName","spring-boot-actuator");
        Map<String,Object> data=new HashMap<>();
        data.put("author","hjh");
        data.put("version","1.0.0");
        builder.withDetails(data);
    }
}
