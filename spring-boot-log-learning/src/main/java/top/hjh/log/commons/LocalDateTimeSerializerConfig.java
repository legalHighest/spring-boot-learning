package top.hjh.log.commons;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 19 15
 **/
//配置全局的 LocalDateTime 格式化
    @Configuration
public class LocalDateTimeSerializerConfig {

        @Value("${spring.jackson.date-format}")
    private String DATE_TIME_PATTERN;


        @Value("${spring.jackson.date-format}")
    private String DATE_PATTERN;

        @Bean
        public Converter<String, LocalDate> localDateConverter() {
            return new Converter<String, LocalDate>() {
                @Override
                public LocalDate convert(String source) {
                    if (source.trim().length() == 0) {
                        return null;
                    }
                    try {
                        return LocalDate.parse(source);
                    } catch (Exception e) {
                        return LocalDate.parse(source, DateTimeFormatter.ofPattern(DATE_PATTERN));
                    }
                }
            };
        }

    /** * string转localdatetime*/
    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                if (source.trim().length() == 0) {
                    return null;
                }
                // 先尝试ISO格式: 2019-07-15T16:00:00
                try {
                    return LocalDateTime.parse(source);
                } catch (Exception e) {
                    return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
                }
            }
        };
    }

    /** * 统一配置 LocalDateTime 格式化*/
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        return builder -> {
            builder.simpleDateFormat(DATE_TIME_PATTERN);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
            builder.modules(module);
        };
    }
}


