package top.hjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 21 10
 **/
@Configuration(proxyBeanMethods = false)
public class RedisConfiguration {

    @Bean
    public  RedisCacheConfiguration  redisCacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
    }
    @Bean
    public RedisCacheManager userCacheManager(RedisConnectionFactory connectionFactory,
                                              RedisCacheConfiguration redisCacheConfiguration) {
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(redisCacheConfiguration.entryTtl(Duration.ofMinutes(1))).build();
    }
}
