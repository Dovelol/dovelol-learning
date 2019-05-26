package com.dove.lol.dovelol.demo.date201905.demo20190525;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceDemo {

    String name()default "";
}
