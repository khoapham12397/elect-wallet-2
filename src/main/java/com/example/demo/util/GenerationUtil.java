package com.example.demo.util;

import java.util.UUID;

public class GenerationUtil {
	private GenerationUtil() {}
	public static String generateId() {
		return UUID.randomUUID().toString();
	}
}
