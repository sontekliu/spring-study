package com.javaliu.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 描 述：  TODO
 * 类 名：EnableHelloWorld
 * 作 者：liushijun
 * 创 建：2019年06月05日 09:40:00
 * 版 本：V1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
// @Import(HelloWorldConfigure.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
