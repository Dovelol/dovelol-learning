package com.dove.lol.dovelol.daily.practise.q20190723;

/**
 * @author Dovelol
 * @date 2019/7/23 23:32
 */
public enum PowerOfTen {

    /**
     *  以上程序输出内容是？

     *  (a) one ten hundred
     *  (b) one ten 100
     *  (c) 编译错误
     *  (d) 以上都不是
     */


    ONE(1), TEN(10),
    HUNDRED(100) {
        @Override
        public String toString() {
            return Integer.toString(HUNDRED.val);
        }
    };
    
    private final int val;

    PowerOfTen(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(ONE + " " + TEN + " " + HUNDRED);
    }
}