
import com.job.Application;
import com.job.entity.User;
import com.job.entity.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before() {
//        userRepository.deleteAll();
        userRepository.save(new User("AAA", 10));
        cacheManager.getCache("users").clear();
    }

    @Test
    public void test() throws Exception {

        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());

        u1.setAge(20);
        userRepository.save(u1);
        User u3 = userRepository.findByName("AAA");
        System.out.println("第三次查询：" + u3.getAge());

    }

}
