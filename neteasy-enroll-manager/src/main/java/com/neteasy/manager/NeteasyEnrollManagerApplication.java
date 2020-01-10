package com.neteasy.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  // 开启事务注解
@MapperScan("com.neteasy.manager.modules.*.dao")   // 扫描mapper接口
public class NeteasyEnrollManagerApplication {

    public static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(NeteasyEnrollManagerApplication.class, args);
    }

}
