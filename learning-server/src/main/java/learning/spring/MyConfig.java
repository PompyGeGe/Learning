package learning.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 皮皮
 * @Date: 2024/7/3 15:48
 * @Description:
 */
@Configuration
@ComponentScan("learning.*")
public class MyConfig {

    /*@Bean
    public StudentService studentService1() {
        return new StudentService();
    }*/


}
