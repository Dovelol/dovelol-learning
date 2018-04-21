package com.dove.lol.dovelol.demo.date201712.demo20171218;

/**
 * @author Dovelol
 * @date 2017/12/18 21:45
 */
public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        final Context context = new Context();
        queryFromDBAction.execute(context);
        System.out.println("The name query successful");
        queryFromHttpAction.execute(context);
        System.out.println("The card id query successful");
        System.out.println("The Name is " + context.getName() + " and CardId " + context.getCardId());
    }
}
