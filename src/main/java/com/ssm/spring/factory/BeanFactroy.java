package com.ssm.spring.factory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * ********************************************************************************
 *    创建service和dao对象的一个工厂类：
 * 1. 需要一个配置文件来配置service和dao
 * 2. 通过读取配置文件中的内容来反射创建对象，
 *    配置文件可以是xml或者properties文件
 * 3. 定义一个Map容器，用于存放要创建的对象
 *
 * *********************************************************************************
 */
public class BeanFactroy {
    private static Properties props;

    //定义一个Map,用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String,Object> beans;

    // 根据bean的名称获取对象
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    // 静态代码块在类初始化的时候只执行一次，执行完便销毁，它仅能初始化类变量，即static修饰的属性


    static {
        props = new Properties();
        // 通过类加载器来获取输入流对象
        InputStream beanConfig = BeanFactroy.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            //加载配置文件，加载之后就可以获取配置文件中的key-value对
            props.load(beanConfig);
            // 取出配置文件中所有的Key：accountService和daoService
            Enumeration keys = props.keys();
            //创建一个Map对象，用于存放创建的对象
            beans = new HashMap<String,Object>();
            while (keys.hasMoreElements()){

                /**
                 * key             value
                 * accountService=com.ssm.spring.service.impl.AccountServiceImpl
                 * daoService=com.ssm.spring.dao.impl.AccountDaoImpl
                 */
                // 遍历key
                String key = keys.nextElement().toString();
                // 根据key获取value
                String beanPath = props.getProperty(key);
                // 反射创建对象
                Object value  = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties错误");
        }
    }

/*    public static <T> T getBean(String beanName) {
        T bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = (T) Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
