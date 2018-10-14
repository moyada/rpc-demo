package cn.moayda.rpc.demo.dubbo.core;

import cn.moayda.rpc.demo.dubbo.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.queryAll());
    }
}
