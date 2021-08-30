package com.example.demo.config;

import io.lettuce.core.RedisURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

@Configuration
public class RedisCacheConfig {
	
	@Value("${spring.redis.host}")
	private String hostName;
	@Value("${spring.redis.port}")
	private Integer port;
	@Value("${spring.redis.password}")
	private String password;

	@Bean(name="redisClient")
	public RedisClient client() {
		RedisURI.Builder sentinelRedisUriBuilder = RedisURI.builder();
		sentinelRedisUriBuilder.withHost("localhost");
		return RedisClient.create(sentinelRedisUriBuilder.build());
	};

	@Bean(name="redisConnection")
	public StatefulRedisConnection connection() {
		return client().connect();
	}
	public void check() {

	}
}
