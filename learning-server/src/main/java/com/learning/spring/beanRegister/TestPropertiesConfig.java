package com.learning.spring.beanRegister;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 皮皮
 * @Date: 2024/6/5 17:57
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "test.properties.value")
@Data
public class TestPropertiesConfig {
    private String a;
    private String b;
}
