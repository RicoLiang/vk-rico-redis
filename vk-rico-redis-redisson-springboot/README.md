# redisson整合Cache
## spring-boot-starter-cache插件
    从3.1开始，spring引入了对Cache的支持。spring-boot通过spring-boot-starter-cache模块实现对Cache的集成。
    [SpringCache（Spring使用Cache）](http://blog.csdn.net/u013068377/article/details/53291789)
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

## spring-data-redis插件
spring-data-redis插件支持jedis，但不支持redisson

## spring-boot-starter-data-redis插件
spring-boot集成了spring-data-redis插件

    redisson可以和spring cache插件整合。
	1)、spring cache是将对象序列化成json字符串存储到redis中的，@Cacheable(cacheNames = "orders")注解必须指定key，
		field是字符串（一般是主键，也可指定生成策略），value是对象序列化后的json字符串；
	
	2)、将对象存储为hash，对象的主键作为key，对象的其他属性作为field，属性的值作为value；
		这个需要单独处理，可以使用Jackson来实现；
		
	3)、spring-session存储的是hash，待研究。
	
	
