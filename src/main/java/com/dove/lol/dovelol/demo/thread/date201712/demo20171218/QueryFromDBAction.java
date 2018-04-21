package com.dove.lol.dovelol.demo.thread.date201712.demo20171218;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/18 21:47
 */
public class QueryFromDBAction {

    public void execute(Context context){

        try {
            TimeUnit.SECONDS.sleep(1);
            String name = "dovelol" + Thread.currentThread().getName();
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
