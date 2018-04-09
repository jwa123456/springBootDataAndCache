import com.job.Application;
import com.job.service.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

		// 保存对象
		User user = new User("abc", 20);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("aaa", 30);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("bbb", 40);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("abc").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("aaa").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("bbb").getAge().longValue());

	}

}
