import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-22 18:09
 **/
public class LaunchTest {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");
        cpx.start();
        System.in.read();
    }
}
