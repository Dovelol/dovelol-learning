package com.dove.lol.dovelol.demo.thread.date201712.demo20171218;

/**
 * @author Dovelol
 * @date 2017/12/18 21:47
 */
public class Context {

    private String name;

    private String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
