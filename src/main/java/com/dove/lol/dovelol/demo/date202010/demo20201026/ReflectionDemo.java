package com.dove.lol.dovelol.demo.date202010.demo20201026;

import org.springframework.util.ReflectionUtils;
import sun.misc.ProxyGenerator;

/**
 * @author Dovelol
 * @date 2020/10/26 23:02
 */
public class ReflectionDemo {


    public static void main(String[] args) throws ClassNotFoundException {
        UserProxy userProxy  = new UserProxy();
        UserService userService = (UserService) userProxy.newInstance();
        System.out.println(userService.getUserById(10L));
        ClassLoaderDemo classLoaderDemo =new ClassLoaderDemo();
        Class<?> aClass = classLoaderDemo.findClass("");


    }


}
class ClassLoaderDemo extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = ProxyGenerator.generateProxyClass("com.dove.lol.dovelol.demo.date202010.demo20201026.$p1", new Class[]{UserService.class});
        return super.defineClass("com.dove.lol.dovelol.demo.date202010.demo20201026.$p1",bytes,0,bytes.length);
    }


}