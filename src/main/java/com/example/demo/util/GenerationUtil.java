package com.example.demo.util;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component("GenerationUtil")
public final class GenerationUtil {
//	@Autowired
//	private StatefulRedisConnection autowiredRedis;
//	private static StatefulRedisConnection redis;
//	@PostConstruct
//	private void init() {redis = this.autowiredRedis;}
	public static String generateId() {
		return UUID.randomUUID().toString();
	}
	// lam sao ma no dua vo duoc ?
	@Autowired
	private RedisTemplate<String, Integer> redisTemplateAutowired;
	
	private static RedisTemplate<String, Integer> redisTemplate;
	
	@PostConstruct
	private void init() {redisTemplate = this.redisTemplateAutowired;}	
	
	public static String generateId(String s){
		//RedisCommands<String, String> com = redis.sync();
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
		String key = s +"_" + date;
		//com.incr(key);
		redisTemplate.opsForValue().increment(key);
		Integer num = redisTemplate.opsForValue().get(key);
		return date + "-" + String.format("%08d",num);
	}
}
