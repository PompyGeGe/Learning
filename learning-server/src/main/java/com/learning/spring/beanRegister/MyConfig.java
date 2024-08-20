package com.learning.spring.beanRegister;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @Author: 皮皮
 * @Date: 2024/7/3 15:48
 * @Description:
 */
@Configuration
@ComponentScan("com.learning.*")
public class MyConfig {



    @Bean(value="bizI18nMessage")
    public MessageSource bizI18nMessage(){
        //To use ResourceBundleMessageSource, we have to create a bean for it in @Configuration class.
        ResourceBundleMessageSource serviceMessageSource = new ResourceBundleMessageSource();
        serviceMessageSource.setAlwaysUseMessageFormat(true);
        serviceMessageSource.setDefaultEncoding("UTF-8");
        serviceMessageSource.setDefaultLocale(Locale.ENGLISH);
        serviceMessageSource.setUseCodeAsDefaultMessage(true);
        serviceMessageSource.setBasename("i18n/BizMessages");//一定要加i18n/，因为BizMessages_en_US.properties等都是在i18n这个路径下的
        return serviceMessageSource;
    }


}
