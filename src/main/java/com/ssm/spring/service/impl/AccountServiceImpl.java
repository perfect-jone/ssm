package com.ssm.spring.service.impl;

import com.ssm.mybatis.bean.User;
import com.ssm.spring.dao.AccountDao;
import com.ssm.spring.dao.impl.AccountDaoImpl;
import com.ssm.spring.factory.BeanFactroy;
import com.ssm.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
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
 *  创建对象
 *      类似<bean></bean>实现的功能
 *      @Component ：对应的id是@Component的属性value,默认是当前类名，首字母小写
 *      @Controller ：一般用在表现层
 *      @Service ：一般用在业务层
 *      @Repository ：一般用在持久层
 *      以上三个注解和@Component的属性和作用是一样的，只是让三层对象更加清晰
 *
 *  注入数据
 *      类似<property></property>实现的功能
 *      @Autowired : 自动按照类型注入，只要容器中有唯一的bean对象类型和要注入的变量类型匹配，则可以注入成功
 *      @Qualifier : 按照类型注入的基础上，再按照名称注入，给属性注解时不能单独使用，必须结合@Autowired注解使用，给方法参数注入时可单独使用
 *      @Resouce : 直接按照bean的id注入，name用于指定bean的id
 *      以上三个注解只能注入其他bean类型的数据，不能注入基本数据类型和String类型，
 *      另外，集合类型的注入只能通过XML的方式来实现
 *      @Value ：注入基本数据类型和String类型，value属性用于指定数据的值，可是使用spring中SpEL（el表达式），${表达式}
 *
 *  改变作用范围
 *      类似scope属性实现的功能
 *      @Scope : 属性value：常用取值有两个singleton和prototype
 *
 *  生命周期
 *      @PostConstruct : 初始化方法注解
 *      @PreDestroy : 销毁方法注解
 *
 *      类似init-method和destroy-method属性实现的功能
 *
 * *****************************************************************************************************************************
 */

// 此注解的作用是将该类交由spring容器管理，spring容器其实就是一个Map集合,key是注解的属性value,value是该类对象
// 如果Component中的属性只有value时，可以省略value,如果不指定value，则默认是当前类名，首字母改小写
@Service(value = "accountService")
@Scope("singleton")
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


    //使用构造方法的方式进行属性注入
/*    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }*/

    @Autowired //自动按照类型注入，只要容器中有唯一的bean对象类型和要注入的变量类型匹配，则可以注入成功
    // 没有赋值只是创建了对象，这里只是注入了对象，并没有注入数据，当引入Autowired注解后，就注入了数据
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount() {
        accountDao.saveAccount();
 /*       System.out.println("name:"+name+",age:"+age+",birthday:"+birthday);
        System.out.println(Arrays.toString(strs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
        System.out.println(user);*/
    }
}
