package com.example.java_demo_test.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching

@Configuration
public class CaffeineCacheConfig {
	
	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManger = new CaffeineCacheManager();
		
		cacheManger.setCaffeine(Caffeine.newBuilder()
				.expireAfterAccess(600 , TimeUnit.SECONDS)
				.initialCapacity(100)
				.maximumSize(500));
		
		return cacheManger;
	}
}
