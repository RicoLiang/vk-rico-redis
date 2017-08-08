package vk.rico.redis.springdataredis.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;
import vk.rico.redis.springdataredis.config.RedisConfig;

@Configuration
public class RedisInit {

	@Autowired
	private RedisConfig redisConfig;

	@Bean(name = "poolConfig")
	public JedisPoolConfig buildPoolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(redisConfig.getMaxTotal());
		poolConfig.setMaxIdle(redisConfig.getMaxIdle());
		poolConfig.setMinIdle(redisConfig.getMinIdle());
		poolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
		poolConfig.setTestOnBorrow(redisConfig.isTestOnBorrow());
		return poolConfig;
	}

	@Bean(name = "redisConnectionFactory", destroyMethod = "destroy")
	public RedisConnectionFactory buildRedisConnectionFactory(JedisPoolConfig poolConfig) {
		JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory();
		jedisConnFactory.setPoolConfig(poolConfig);
		jedisConnFactory.setPort(redisConfig.getPort());
		jedisConnFactory.setHostName(redisConfig.getHost());
		jedisConnFactory.setUsePool(true);
		return jedisConnFactory;
	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Object> buildRedisTemplate(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory connFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(connFactory);
		return template;
	}

	@Bean(name = "stringRedisTemplate")
	public StringRedisTemplate buildStringRedisTemplate(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory connFactory) {
		StringRedisTemplate strTemplate = new StringRedisTemplate();
		strTemplate.setConnectionFactory(connFactory);
		return strTemplate;
	}
}
