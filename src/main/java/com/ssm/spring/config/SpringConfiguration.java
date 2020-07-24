package com.ssm.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/***
 * *********************************************************************************************************
 *
 * @Configuration //表示该类是个配置类
 *
 * @ComponentScan (basePackages = "com.ssm.spring")
 * @ComponentScan (value = "com.ssm.spring")
 * @ComponentScan ("com.ssm.spring")
 * 以上三种方式效果一样，并且和<context:component-scan base-package="com.ssm"/>作用一样
 * 都是扫描com.ssm.spring包下的类
 *
 *  @Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性:
 *          name:用于指定bean的id。当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的
 *  @Import 用于导入其他的配置类
 *
 *  @PropertySource
 *      用于指定properties文件的位置
 *      属性：
 *          value:指定文件的名称和路径
 *          关键字：classpath:表示类路径下
 *
 * ********************************************************************************************************
 */

@Configuration
@ComponentScan("com.ssm.spring")
@PropertySource(value="classpath:jdbc.properties")
public class SpringConfiguration {

    @Value("driver")
    private String driver;

    @Value("url")
    private String url;

    @Value("username")
    private String username;

    @Value("password")
    private String password;

    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("${driver}");
            ds.setJdbcUrl("${url}");
            ds.setUser("${username}");
            ds.setPassword("${password}");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
