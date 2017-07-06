package com.business.delivery.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by chenlile on 17-3-17.
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)//注意，由于MapperScannerConfigurer执行的比较早，所以必须有这个注解
public class MyBatisMapperScannerConfig {

    /**
     * 使用第三方通用mapper，提高单表操作效率
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.business.**.dao");
        Properties properties = new Properties();
        properties.setProperty("mappers", Mapper.class.getName());
        mapperScannerConfigurer.setProperties(properties);
        mapperScannerConfigurer.setMarkerInterface(Mapper.class);
        return mapperScannerConfigurer;
    }
}
