package com.demo.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;

import java.util.Objects;

public class RedissonConfig {

    private RedissonClient redissonClient;

    public RedissonClient getCliente(){
        if(Objects.isNull(this.redissonClient)){
            Config config = new Config();
            config.useSingleServer()
                    .setAddress("redis://127.0.0.1:6370");
            this.redissonClient = Redisson.create();
        }
        return redissonClient;
    }

    public RedissonReactiveClient getReactiveCliente(){
        return getCliente().reactive();
    }

}
