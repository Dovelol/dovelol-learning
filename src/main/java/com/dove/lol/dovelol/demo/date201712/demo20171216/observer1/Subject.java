package com.dove.lol.dovelol.demo.date201712.demo20171216.observer1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dovelol
 * @date 2017/12/16 10:08
 */
public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (this.state == state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    private void notifyAllObserver() {
        observerList.stream().forEach(Observer::update);
    }

}
