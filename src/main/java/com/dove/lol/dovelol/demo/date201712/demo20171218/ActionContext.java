package com.dove.lol.dovelol.demo.date201712.demo20171218;

/**
 * @author Dovelol
 * @date 2017/12/18 22:10
 */
public final class ActionContext {

    private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<Context>();

    private ActionContext() {

    }

    private static volatile ActionContext actionContext;

    public static ActionContext getActionContext() {
        if (actionContext == null) {
            synchronized (ActionContext.class) {
                if (actionContext == null) {
                    actionContext = new ActionContext();
                }
            }
        }
        return actionContext;
    }


}
