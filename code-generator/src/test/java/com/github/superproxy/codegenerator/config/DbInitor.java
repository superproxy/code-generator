package com.github.superproxy.codegenerator.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

@Test
public class DbInitor {
    @Test
    public void init() {
        // 初始化h2数据库
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
    }
}
