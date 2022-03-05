package com.learn.bean;

import org.springframework.context.annotation.Bean;

//不需要spring注解，通过importSelector调用
public class UserConfiguration {
    @Bean
    public User getUser(){
        User testUser = new User();
        testUser.setAge(12);
        testUser.setUsername("long");
        return testUser;
    }
}
