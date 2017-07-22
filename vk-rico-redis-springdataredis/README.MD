# 学习spring-data-redis插件
## spring-data-redis插件
spring-data-redis插件支持jedis，但不支持redisson
```
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-redis</artifactId>
	<version>1.8.4.RELEASE</version>
</dependency>
```

## spring-boot-starter-data-redis插件
spring-boot集成了spring-data-redis插件
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

## spring-boot-starter-cache插件
从3.1开始，spring引入了对Cache的支持。
[SpringCache（Spring使用Cache）](http://blog.csdn.net/u013068377/article/details/53291789)
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```