package com.dove.lol.dovelol.demo.date201903.demo20190303;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Dovelol
 * @date 2019/3/3 18:38
 */
public class KryoDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
        // ...
        Output output = new Output(new FileOutputStream("file.bin"));
        User user = new User("yzh", 20);
        kryo.writeObject(output, user);
        output.close();
        // ...
        Input input = new Input(new FileInputStream("file.bin"));
        User user1 = kryo.readObject(input, User.class);
        input.close();

        System.out.println(user1);
    }


    private static class User {

        private String name;

        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
