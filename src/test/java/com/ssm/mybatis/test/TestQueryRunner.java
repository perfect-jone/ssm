package com.ssm.mybatis.test;

import com.ssm.spring.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jone
 * @create 2020-07-23 11:22
 */
public class TestQueryRunner {

    /**
     * *****************************************************************************************
     * 使用Junit单元测试：测试我们的配置
     * Spring整合junit的配置
     *      1、导入spring整合junit的jar(坐标)
     *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
     *         @Runwith
     *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
     *         @ContextConfiguration
     *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
     *                  classes：指定注解类所在地位置
     *
     *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
     *
     * *****************************************************************************************
     */

    /**
     * 测试QueryRunner是否单例
     *
     */

    @Test
    public void testQueryRunner(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
