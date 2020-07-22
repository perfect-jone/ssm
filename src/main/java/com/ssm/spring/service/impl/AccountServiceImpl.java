package com.ssm.spring.service.impl;

import com.ssm.mybatis.bean.User;
import com.ssm.spring.dao.AccountDao;
import com.ssm.spring.dao.impl.AccountDaoImpl;
import com.ssm.spring.factory.BeanFactroy;
import com.ssm.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 账户的业务层接口
 */

/**
 * ****************************************************************************************************************************
 * <bean id="accountService" class="com.ssm.spring.service.impl.AccountServiceImpl" scope="" init-method="" destroy-method="">
 *     <property name="" value="" ref=""/>
 * </bean>
 *
 *  用于创建对象的
 *      类似<bean></bean>实现的功能
 *      @Component注解，对应的id是@Component的属性value,默认是当前类名，首字母小写
 *
 *  用于注入数据的
 *      类似<property></property>实现的功能
 *  用于改变作用范围的
 *      类似scope属性实现的功能
 *  和生命周期相关的
 *      类似init-method和destroy-method属性实现的功能
 *
 * *****************************************************************************************************************************
 */

// 此注解的作用是将该类交由spring容器管理，spring容器其实就是一个Map集合,key是注解的属性value,value是该类对象
// 如果Component中的属性只有value时，可以省略value,如果不指定value，则默认是当前类名，首字母改小写
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {
    // 如果是经常变化的数据，并不适合于注入的方式
    private String name;
    private Integer age;
    private Date birthday;
    private String[] strs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<Integer,String> myMap;
    private Properties myProps;

    //注入实体类
    private User user;

    // 使用set的方式进行属性注入
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<Integer, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //使用构造方法的方式进行属性注入
/*    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }*/

    //private AccountDao accountDao = new AccountDaoImpl();
    //AccountDao accountDao = (AccountDao) BeanFactroy.getBean("daoService");

    public void saveAccount() {
        //accountDao.saveAccount();
        System.out.println("name:"+name+",age:"+age+",birthday:"+birthday);
        System.out.println(Arrays.toString(strs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
        System.out.println(user);
    }
}
