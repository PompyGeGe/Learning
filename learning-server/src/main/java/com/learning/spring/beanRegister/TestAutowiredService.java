package com.learning.spring.beanRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/7/29 18:34
 * @Description:
 * 注册集合
 */
@Service
public class TestAutowiredService {

//    idea不推荐
//    @Autowired
//    private List<PersonService> personServiceList;

    //注入list集合
    private List<PersonService> personServiceList;

    //用构造方法注入时，@Autowired可以去掉
//    @Autowired
    public TestAutowiredService(List<PersonService> personServiceList){
        this.personServiceList = personServiceList;
    }

//    用set方法注入时，@Autowired不能去掉
//    @Autowired
//    public void setTestAutowiredService(List<PersonService> personServiceList){
//        this.personServiceList = personServiceList;
//    }

    public void printPersonClassInfo(){
        for (PersonService personService : personServiceList) {
            LocaleContextHolder.getLocale();//这里用来探究下LocaleContextHolder.getLocale()的原理。
            System.out.println(personService.getClass());
        }
    }

}
