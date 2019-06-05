package com.javaliu.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描 述：  TODO
 * 类 名：HelloWorld
 * 作 者：liushijun
 * 创 建：2019年06月05日 09:41:00
 * 版 本：V1.0.0
 */
public class HelloWorldConfigure {


    @Bean
    public String helloWorld(){
        return "Hello World 2019";
    }

}
