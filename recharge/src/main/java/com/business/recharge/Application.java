package com.business.recharge;

import com.business.recharge.utils.IDGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by chenlile on 17-3-14.
 */

@SpringBootApplication//@SpringBootApplication 注解等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan
@EnableAsync
public class Application {

    public static void main(String[] args) {
        if(args.length==0){
            throw new RuntimeException("请输入至少一个参数，表示机器编码");
        }

        IDGenerator instance = IDGenerator.getInstance();
        instance.setServerCode(Integer.valueOf(args[0]));
        SpringApplication.run(Application.class, args);
    }
}
