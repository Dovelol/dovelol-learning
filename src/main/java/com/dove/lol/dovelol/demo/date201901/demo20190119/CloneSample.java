package com.dove.lol.dovelol.demo.date201901.demo20190119;

/**
 * @author Dovelol
 * @date 2019/1/19 15:54
 */
public class CloneSample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Data data = new Data();
        Data clone = (Data) data.clone();

        System.out.println(data.equals(clone));
        System.out.println(data.hashCode() == clone.hashCode());
    }

}

class Data implements Cloneable {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



}
