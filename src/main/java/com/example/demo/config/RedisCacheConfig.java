package com.example.demo.config;

import io.lettuce.core.RedisURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

@Configuration
public class RedisCacheConfig {
	
	@Bean(name="redisClient")
	public RedisClient client() {
		RedisURI.Builder sentinelRedisUriBuilder = RedisURI.builder();
		sentinelRedisUriBuilder.withHost("redis-14748.c1.asia-northeast1-1.gce.cloud.redislabs.com").withPort(14748).withPassword("4AKuNXWB8BAQ93fTY2ryZLJeUTcimp9P".toCharArray());
		return RedisClient.create(sentinelRedisUriBuilder.build());
	};
	@Bean(name="redisConnection")
	public StatefulRedisConnection connection() {
		return client().connect();
	}
	public void check() {

	}
}
