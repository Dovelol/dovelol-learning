package com.dove.lol.dovelol.demo.date201805.demo20180512;

/**
 * @author Dovelol
 * @date 2018/5/12 19:46
 */
public class LoggingWidget extends Widget {

    public LoggingWidget() {
        System.out.println("LoggingWidget constructor");
    }

    @Override
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }

}
