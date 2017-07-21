# vk-rico-redis-redisson-springboot
spring-boot、spring-data-redis、redisson整合

spring-boot-starter-redis里面集成了spring-data-redis，而spring-data-redis支持的是jedis，不支持redisson
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


redisson可以和spring cache插件整合。
存储对象：

	1)、spring cache是将对象序列化成json字符串存储到redis中的，@Cacheable(cacheNames = "orders")注解必须指定key，
		field是字符串（一般是主键，也可指定生成策略），value是对象序列化后的json字符串；
	
	2)、将对象存储为hash，对象的主键作为key，对象的其他属性作为field，属性的值作为value；
		这个需要单独处理，可以使用Jackson来实现；
		
	3)、spring-session存储的是hash，待研究。
	
	
