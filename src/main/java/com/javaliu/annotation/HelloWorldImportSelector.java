package com.javaliu.annotation;

import com.javaliu.configure.HelloWorldConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Iterator;
import java.util.Set;

/**
 * 描 述：  TODO
 * 类 名：HelloWorldImportSelector
 * 作 者：liushijun
 * 创 建：2019年06月05日 09:51:00
 * 版 本：V1.0.0
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> set = importingClassMetadata.getAnnotationTypes();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        return new String[]{HelloWorldConfigure.class.getName()};
    }
}
