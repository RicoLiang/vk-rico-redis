# vk-rico-redis-redisson-springboot
spring-boot、spring-data-redis、redisson整合

spring-boot-starter-redis里面包含spring-data-redis、jedis两个插件
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-redis</artifactId>
	<exclusions>
		<exclusion>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
		</exclusion>
	</exclusions>
</dependency>
