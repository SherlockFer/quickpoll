package com.apress.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisTemplateConfig {

	@Bean
	RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory,
			Jackson2JsonRedisSerializer<String> serializer) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setDefaultSerializer(serializer);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public Jackson2JsonRedisSerializer<String> jackson2JsonRedisSerializer() {
		return new Jackson2JsonRedisSerializer<>(String.class);
	}
}