package com.example.spring.importlearn;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public MyImportSelector() {
        System.out.println("MyImportSelector.constructor----");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelector.selectImports");
        return new String[]{"com.example.spring.importlearn.ACls"};
    }
}
