import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.impl.UserDaoImpl;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.util.RedisUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * @program: BulemsunIsland
 * @description: test
 * @author: Windlinxy
 * @create: 2021-10-09 17:01
 **/
public class Test {
    @org.junit.Test
    public void test(){
        System.out.println(RedisUtil.getZ("key1"));
    }
}

