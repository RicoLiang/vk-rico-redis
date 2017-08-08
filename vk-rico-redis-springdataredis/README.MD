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
`在spring-boot低版本中（如1.3.4版本中），是spring-boot-starter-redis插件，可以从spring-boot具体版本中查看到相应的插件`
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-redis</artifactId>
</dependency>
```	

## spring-boot-starter-cache插件
    从3.1开始，spring引入了对Cache的支持。spring-boot通过spring-boot-starter-cache模块实现对Cache的集成。
  [SpringCache（Spring使用Cache）](http://blog.csdn.net/u013068377/article/details/53291789)
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

## spring-boot 1.5.4版本Junit测试
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
```
### spring-boot 1.4之前
```
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
```
[Spring Boot 1.5.2 Junit测试](http://blog.sina.com.cn/s/blog_70c9b8140102wyeg.html)
