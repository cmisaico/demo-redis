package com.demo.redis;

import com.demo.redis.config.RedissonConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.redisson.api.RedissonReactiveClient;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

	private final RedissonConfig redissonConfig = new RedissonConfig();
	protected RedissonReactiveClient cliente;

	@BeforeAll
	public void setCliente(){
		this.cliente = this.redissonConfig.getReactiveCliente();
	}

	@AfterAll
	public void shutdown(){
		this.cliente.shutdown();
	}

}
