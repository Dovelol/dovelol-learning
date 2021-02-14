package com.dove.lol.dovelol.demo.date202012.demo20201205;

/**
 * @author Dovelol
 * @date 2020/12/5 23:32
 */
public class HashCodeDemo {

    public static void main(String[] args) {
        for(int i=0;i <400-1;i++){
            int hashCode = indexKeyHashMethod(String.valueOf(i));
            System.out.println(i+1+": "+i+": "+hashCode+": "+( hashCode% 10));
        }
    }

    public static int indexKeyHashMethod(final String key) {
        int keyHash = key.hashCode();
        int keyHashPositive = Math.abs(keyHash);
        if (keyHashPositive < 0)
            keyHashPositive = 0;
        return keyHashPositive;
    }

}
