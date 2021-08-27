package com.example.demo.util;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component("GenerationUtil")
public final class GenerationUtil {
	@Autowired
	private StatefulRedisConnection autowiredRedis;
	private static StatefulRedisConnection redis;
	public static String generateId() {
		return UUID.randomUUID().toString();
	}
	@PostConstruct
	private void init() {
		redis = this.autowiredRedis;
	}
	public static String generateId(String s){
		RedisCommands<String, String> com = redis.sync();
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
		String key = s +"_" + date;
		com.incr(key);
		Integer num = Integer.parseInt(com.get(key));
		return date + "-" + String.format("%08d",num);
	}
}
