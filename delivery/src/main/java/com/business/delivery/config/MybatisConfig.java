package com.business.delivery.config;

import com.github.pagehelper.PageHelper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by chenlile on 17-3-16.
 */
@Configuration
@EnableTransactionManagement
//@MapperScan(basePackages = MybatisConfig.PACKAGE,sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig  {

    static final String PACKAGE = "com.business.acceptor.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Autowired
    private Environment env;


    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        config.setJdbcUrl(env.getProperty("spring.datasource.url"));
        config.setUsername(env.getProperty("spring.datasource.username"));
        config.setPassword(env.getProperty("spring.datasource.password"));

        HikariDataSource ds = new HikariDataSource(config);
        return ds;

    }



    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(PageHelper pageHelper){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPlugins(new Interceptor[]{pageHelper});//注入分页插件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//
//    @Bean   使用@MapperScan可以不用配置这个
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    @Bean
    @Primary
    public PlatformTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    //配置分页插件
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}
