package com.rui.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: Cargo服务提供者启动类
 * @author: caihongrui
 * @createtime: 2019-11-22 16:50
 **/
public class CargoProvider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
