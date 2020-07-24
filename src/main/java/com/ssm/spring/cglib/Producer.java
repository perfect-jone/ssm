package com.ssm.spring.cglib;



/**
 * @author Jone
 * @create 2020-07-23 16:56
 */
public class Producer{

    // 销售商品
    public void saleProduct(float money){
        System.out.println("销售商品，并拿到"+money+"元！");
    }

    // 售后服务
    public void service(float money){
        System.out.println("售后服务");
    }
}
