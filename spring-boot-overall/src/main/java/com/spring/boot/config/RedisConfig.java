package com.spring.boot.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.spring.boot.serializer.KryoRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/21 16:18
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);

        KryoRedisSerializer<Object> kryoRedisSerializer = new KryoRedisSerializer(Object.class);

        //小范围指定白名单
        ParserConfig.getGlobalInstance().addAccept("com.spring.boot.");

        //value序列化方式设置为FastJsonRedisSerializer/kryoRedisSerializer
        //FastJsonRedisSerializer不支持get时Value为对象，kryoRedisSerializer支持get时value为对象
        redisTemplate.setValueSerializer(kryoRedisSerializer);
        redisTemplate.setHashValueSerializer(kryoRedisSerializer);

        //key序列化方式设置为String
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
