package com.business.callback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chenlile on 17-3-14.
 */

@SpringBootApplication//@SpringBootApplication 注解等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan
public class CallBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallBackApplication.class, args);
    }
}
