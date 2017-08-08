package vk.rico.redis.springdataredis;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Repository;

@Repository("hashMapping")
public class HashMapping {
	@Resource(name = "redisTemplate")
	private HashOperations<String, byte[], byte[]> hashOperations;

	private HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

	public <T> void writeHash(String key, T obj) {
		Map<byte[], byte[]> mappedHash = mapper.toHash(obj);
		hashOperations.putAll(key, mappedHash);
	}

	@SuppressWarnings("unchecked")
	public <T> T loadHash(String key) {
		Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
		return (T) mapper.fromHash(loadedHash);
	}

	private HashMapper<Object, String, Object> jacksonMapper = new Jackson2HashMapper(true);
	//
	// @Resource(name = "redisTemplate")
	// private HashOperations<String, String, Object> hashOperations2;
	//
	// public <T> void writeHash2(String key, T obj) {
	// Map<String, Object> hash = jacksonMapper.toHash(obj);
	// hashOperations2.putAll(key, hash);
	// }
	//
	// @SuppressWarnings("unchecked")
	// public <T> T loadHash2(String key) {
	// Map<String, Object> entries = hashOperations2.entries(key);
	// return (T) jacksonMapper.fromHash(entries);
	// }

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public <T> void writeHash2(String key, T obj) {
		HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
		Map<String, Object> hash = jacksonMapper.toHash(obj);
		opsForHash.putAll(key, hash);
		;
	}

	@SuppressWarnings("unchecked")
	public <T> T loadHash2(String key) {
		HashOperations<String, String, Object> opsForHash = redisTemplate.opsForHash();
		Map<String, Object> entries = opsForHash.entries(key);
		return (T) jacksonMapper.fromHash(entries);
	}
}
