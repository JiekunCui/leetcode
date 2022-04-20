package com.example.spring.importlearn;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyDeferredImportSelector implements DeferredImportSelector {

    public MyDeferredImportSelector() {
        System.out.println("MyDeferredImportSelector.constructor----");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyDeferredImportSelector.selectImports----");
        return new String[]{"com.example.spring.importlearn.BCls"};
    }
}
