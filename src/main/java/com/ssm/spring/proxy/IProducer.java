package com.ssm.spring.proxy;

/**
 * @author Jone
 * @create 2020-07-23 16:58
 */
public interface IProducer {

    // 销售商品
    public void saleProduct(float money);

    // 售后服务
    public void service(float money);
}
