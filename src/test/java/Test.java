import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.impl.UserDaoImpl;
import com.bluemsun.island.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: BulemsunIsland
 * @description: test
 * @author: Windlinxy
 * @create: 2021-10-09 17:01
 **/
public class Test {
    @org.junit.Test
    public void test(){
        Thread t1 = new Thread("1111");
        Thread t2 = new Thread("2222");
        t1.start();
        t2.start();
        System.out.println(233);
    }
}

class Thread extends java.lang.Thread{
    private String name;

    public Thread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
        UserDao userDao = context.getBean("userDao", UserDaoImpl.class);
        userDao.insertUser(new User("u56","sad546677","624556789102"));
        System.out.println(1);
    }
}
