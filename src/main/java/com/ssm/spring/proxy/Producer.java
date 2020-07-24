package com.ssm.spring.proxy;

/**
 * @author Jone
 * @create 2020-07-23 16:56
 */
public class Producer implements IProducer{

    // 销售商品
    public void saleProduct(float money){
        System.out.println("销售商品，并拿到"+money+"元！");
    }

    // 售后服务
    public void service(float money){
        System.out.println("售后服务");
    }
}
