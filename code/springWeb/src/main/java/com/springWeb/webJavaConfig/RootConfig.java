package com.springWeb.webJavaConfig;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = { "com.springWeb.service","com.springWeb.aspect" })
@PropertySource("classpath:dataBase.properties")
@MapperScan("com.springWeb.dao")
@EnableAspectJAutoProxy
public class RootConfig {
    @Bean
    public DataSource getDataSource(@Value("${driverClassName}") String driverClassName, @Value("${url}") String url,
                                    @Value("${username}") String username, @Value("${password}") String password){
        username = "scott";
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return  dataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return  sqlSessionFactoryBean.getObject();
    }

}
