import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @description: CompanyProvider启动测试类
 * @author: caihongrui
 * @createtime: 2019-11-22 10:30
 **/
public class CompanyProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
        classPathXmlApplicationContext.start();
        System.in.read();  //按任意键退出
    }
}
