package com.learn.test;

import com.learn.bean.EnableUserBean;
import com.learn.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableUserBean
public class TestApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestApplication.class);
        User bean1 = (User) ac.getBean("getUser");
        User bean2 = ac.getBean(User.class);
        System.out.println("by Name:"+bean1);
        System.out.println("by Class:"+bean2);
    }
}
