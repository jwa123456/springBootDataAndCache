import com.job.Application;
import com.job.entity.Message;
import com.job.service.MessageRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: wei.jiang
 * @Date: Created on 2018/4/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MongoTest {

    @Autowired
    private MessageRepository messageRepository;

    @Before
    public void setUp() {
        messageRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        String id = ObjectId.get().toString();
        messageRepository.save(new Message(id, "aaa", "bbb", 11));
        messageRepository.save(new Message(ObjectId.get().toString(), "ccc", "ddd", 22));
        messageRepository.save(new Message(ObjectId.get().toString(), "eee", "fff", 33));
        Assert.assertEquals(3, messageRepository.findAll().size());

        // 删除一个User，再验证User总数
        Message m = messageRepository.findOne(id);
        messageRepository.delete(m);
        Assert.assertEquals(2, messageRepository.findAll().size());

        // 删除一个User，再验证User总数
        m = messageRepository.findByTitle("ccc");
        messageRepository.delete(m);
        Assert.assertEquals(1, messageRepository.findAll().size());

    }
}
