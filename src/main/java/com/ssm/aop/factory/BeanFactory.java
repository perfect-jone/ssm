package com.ssm.aop.factory;

import com.ssm.aop.service.IAccountService;
import com.ssm.aop.utils.TransactionManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     *
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */

                    // 整个invoke方法就是环绕通知
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if("test".equals(method.getName())){
                            return method.invoke(accountService,args);
                        }

                        Object rtValue = null;
                        try {
                            //1.开启事务，前置通知
                            txManager.beginTransaction();
                            //2.执行操作，明确的切入点方法调用
                            rtValue = method.invoke(accountService, args);
                            //3.提交事务，后置通知
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚操作，异常通知
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接，最终通知
                            txManager.release();
                        }
                    }
                });
    }
}
