package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

@Configuration
public class RedisCacheConfig {
	
	@Bean(name="redisClient")
	public RedisClient client() {
		return RedisClient.create("redis://localhost");
	};
	@Bean(name="redisConnection")
	public StatefulRedisConnection connection() {
		return client().connect();
	}
	public void check() {
		
	}
}
