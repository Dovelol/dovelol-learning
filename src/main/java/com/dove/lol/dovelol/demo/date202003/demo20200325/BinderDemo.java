package com.dove.lol.dovelol.demo.date202003.demo20200325;

import com.dove.lol.dovelol.model.User;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author Dovelol
 * @date 2020/3/25 22:52
 */
public class BinderDemo {

    public static void main(String[] args) {
        ConfigurableEnvironment environment = new StandardEnvironment();
        User user = new User();
        user.setAge(10);
        user.setId(11L);
        user.setName("yzh");
        User user1 = Binder.get(environment).bind("spring.main", Bindable.ofInstance(user)).get();
        System.out.println(environment.getSystemEnvironment());


    }

}
