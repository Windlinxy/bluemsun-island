import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.impl.UserDaoImpl;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.util.RedisUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * @program: BulemsunIsland
 * @description: test
 * @author: Windlinxy
 * @create: 2021-10-09 17:01
 **/
public class ExtraTest {
    @org.junit.Test
    public void test(){
        //RedisUtil.set("user",new User("123","123","123"));
        System.out.println(RedisUtil.getUser(1));

    }

    @Test
    public void stringTest(){
        String test = "D:\\TomCat\\apache-tomcat-8.5.59\\webapps\\bluemsun_island\\images\\3a9e5ab9-bb1f.png";
        System.out.println(test.replace("\\bluemsun_island", ""));
        System.out.println();
    }
}

