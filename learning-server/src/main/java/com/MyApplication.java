package com;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: 皮皮
 * @Date: 2022/2/14 21:55
 * @Description:
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.learning.spring.mybatis.functionTest.mapper")
public class MyApplication {
    //这里报错，因为放到了默认的java目录下了，需要再建一个包com，把这个启动类和其他包都移动到com里，这里不报错，也不需要用@ComponentScan了,这里@ComponentScan其实是多余的。

    public static void main(String[] args) {
        SpringApplication.run(MyApplication .class, args);
    }


}
