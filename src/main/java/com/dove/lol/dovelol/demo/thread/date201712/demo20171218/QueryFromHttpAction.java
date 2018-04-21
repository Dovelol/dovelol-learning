package com.dove.lol.dovelol.demo.thread.date201712.demo20171218;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/18 21:50
 */
public class QueryFromHttpAction {

    public void execute(Context context) {
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "410102" + Thread.currentThread().getName();
    }

}
