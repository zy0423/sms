import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sms.controller.*;

/**
 * Created by zy on 2016/5/27.
 */
public class Test {
    public static void main(String ages[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloController obj = (HelloController) context.getBean("helloController");
    }
}
