package com.dove.lol.dovelol.demo.date201905.demo20190525;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2019/5/25 13:54
 */
@ServiceDemo(name = "abc")
public class AnnotationDemo {


    public static void main(String[] args) {
        AnnotatedElement annotatedElement = AnnotationDemo.class;

        System.out.println(Arrays.toString(annotatedElement.getAnnotations()));

        System.out.println();


        System.out.println(AnnotationDemo.class.getTypeName());


        ReflectionUtils.doWithMethods(ServiceDemo.class, method -> {
            System.out.println(method.getName());
        });

        System.out.println(Target.class.getPackage());
        System.out.println(Target.class.getName());


        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(ServiceDemo.class);


        System.out.println(annotationMetadata.getAnnotationTypes());

        try {
            SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
            MetadataReader metadataReader = factory.getMetadataReader(ServiceDemo.class.getName());

            AnnotationMetadata annotationMetadata1 = metadataReader.getAnnotationMetadata();

            int times = 10 * 10000;

            System.out.println("===");
            System.out.println(annotationMetadata1.getAnnotationTypes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
