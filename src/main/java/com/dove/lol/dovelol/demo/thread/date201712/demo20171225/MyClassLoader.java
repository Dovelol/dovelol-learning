package com.dove.lol.dovelol.demo.thread.date201712.demo20171225;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Dovelol
 * @date 2017/12/25 21:56
 */
public class MyClassLoader extends ClassLoader {

    private static final String DEFAULT_DIR = "E:\\xm\\";

    private String dir = DEFAULT_DIR;

    public String classLoaderName;

    public MyClassLoader() {
        super();
    }

    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File file = new File(dir, classPath + ".class");
        if (!file.exists()) {
            throw new ClassNotFoundException("The class " + name + " not found ");
        }
        byte[] classBytes = loadClassBytes(file);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("load the class " + name + " failed.");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);

    }

    private byte[] loadClassBytes(File file) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}
