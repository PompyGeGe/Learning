package com.learning.spring.mybatis.functionTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.learning.spring.mybatis.functionTest.model.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/7/21 17:55
 * @Description:
 * 这里用配置类的方式去自己定义bean，而不用springboot的自动配置的方式。
 * 如果想用springboot的自动配置，则需要引入springboot的druid-spring-boot-starter和mybatis-spring-boot-starter依赖包。
 *
 */
@Configuration
public class MyBeanConfig {

    //自己定义数据源
    @Bean
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/com.test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    //自己定义mybatis的SqlSessionFactory
    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {//如果这个方法有参数，Spring会尝试从容器中查找与参数类型相匹配的Bean，并将它们注入到方法中
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml")); //指定classpath里的所有*.xml资源文件的位置（资源文件的位置是/src/main/resources，其被构建后作为classpath的一部分)
                                                                                                   //new PathMatchingResourcePatternResolver().getResources()是spring的方法，其可以被getClass().getClassLoader().getResourceAsStream()等去代替
        //sqlSessionFactoryBean.setTypeAliasesPackage("com.learning.spring.mybatis.functionTest.model1"); //指定实体类的包路径
        return sqlSessionFactoryBean.getObject();
    }

}
