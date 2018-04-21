package com.dove.lol.dovelol.demo.date201712.demo20171218;

/**
 * @author Dovelol
 * @date 2017/12/18 21:56
 */
public class ContextTest {

    public static void main(String[] args) {
//        IntStream.rangeClosed(1, 5).forEach(i -> {
//            new Thread(new ExecutionTask()).start();
//        });

        Context context = new Context();
        context.setName("123");
        context.setCardId("456");
        add(context);
        System.out.println(context.toString());
        System.out.println(context.hashCode());
    }

    public static void add(Context context) {
        context.setCardId(context.getCardId() + "d");
        context.setName(context.getName() + "d");
        System.out.println(context.hashCode());
    }
}
