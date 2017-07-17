package com.business.dubbo.charge;

import com.business.dubbo.charge.utils.IDGenerator;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by chenlile on 17-3-14.
 */

@SpringBootApplication//@SpringBootApplication 注解等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan
public class DubboServiceApplication {

    public static void main(String[] args) {
        if(args.length==0){
            throw new RuntimeException("请输入至少一个参数，表示机器编码");
        }
        IDGenerator iDGenerator = IDGenerator.getInstance();
        iDGenerator.setServerCode(Integer.getInteger(args[0]));

        ConfigurableApplicationContext run = SpringApplication.run(DubboServiceApplication.class, args);

    }
}
