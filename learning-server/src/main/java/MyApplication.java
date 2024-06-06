import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: 皮皮
 * @Date: 2022/2/14 21:55
 * @Description:
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"controller","learning"})
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication .class, args);
    }


}
