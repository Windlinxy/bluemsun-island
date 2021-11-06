import com.bluemsun.island.util.RedisUtil;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Test
    public void stringToDateTest() {
        try{
            Date date = DateFormat.getDateInstance().parse("2020-12-10");
            System.out.println(date);
            Date date1 = new Date();
            System.out.println(date1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void dateTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.parse("2021-12-10 15:10:01"));
    }


    @Test
    public void aTask(){
//        try {
//            TimeUnit.SECONDS.sleep( 20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf.format(new Date())+"*********A任务每10秒执行一次进入测试");
    }
}

