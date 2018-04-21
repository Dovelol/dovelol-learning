package com.dove.lol.dovelol.demo.date201802.demo20180204;

import java.util.Random;

/**
 * @author Dovelol
 * @date 2018/2/4 19:19
 */
public class SimpleSkipList<E extends Comparable<E>> {

    private final static byte HEAD_BIT = (byte) -1;

    private final static byte TAIL_BIT = (byte) 1;

    private final static byte DATA_BIT = (byte) 0;

    private final Node<E> NULL = (Node<E>) null;

    private static class Node<E> {
        private E value;
        private Node<E> up, down, left, right;
        private byte bit;

        Node(E value, byte bit) {
            this.value = value;
            this.bit = bit;
        }

        Node(E value) {
            this(value, DATA_BIT);
        }

        @Override
        public String toString() {
            return value + " bit:" + bit;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int height;
    private Random random;

    public SimpleSkipList() {
        this.head = new Node(NULL, HEAD_BIT);
        this.tail = new Node(NULL, TAIL_BIT);
        head.right = tail;
        tail.left = head;
        this.random = new Random(System.currentTimeMillis());

    }

    private <E extends Comparable<E>> Node<E> find(E element) {
        Node<E> currnet = (Node<E>) head;
        for (; ; ) {
            while (currnet.right.bit != TAIL_BIT && currnet.right.value.compareTo(element) <= 0) {
                currnet = currnet.right;
            }

            if (currnet.down != null) {
                currnet = currnet.down;
            } else {
                break;
            }
        }
        //the current <= element < current.right(if exist)
        return currnet;

    }

    public boolean contains(E element) {
        Node<E> node = this.find(element);
        return node == element;

    }

    public E get(E element) {
        Node<E> node = this.find(element);
        return node.value.equals(element) ? node.value : null;
    }

    public void add(E element) {
        Node<E> nearNode = this.find(element);
        Node<E> newNode = new Node<>(element);
        newNode.left = nearNode;
        newNode.right = nearNode.right;
        nearNode.right.left = newNode;
        nearNode.right = newNode;

        int currentLevel = 0;

        while (random.nextDouble() < 0.5d) {

            if (currentLevel >= height) {
                height++;

                Node<E> dumyHead = new Node<>(null, HEAD_BIT);
                Node<E> dumyTail = new Node<>(null, TAIL_BIT);

                dumyHead.right = dumyTail;
                dumyHead.down = head;
                head.up = dumyHead;


                dumyTail.left = dumyHead;
                dumyTail.down = tail;
                tail.up = dumyTail;

                head = dumyHead;
                tail = dumyTail;
            }


            while ((nearNode != null) && nearNode.up == null) {
                nearNode = nearNode.left;
            }

            nearNode = nearNode.up;
            Node<E> upNode = new Node<>(element);
            upNode.left = nearNode;
            upNode.right = nearNode.right;
            upNode.down = newNode;

            nearNode.right.left = upNode;
            nearNode.right = upNode;

            newNode.up = upNode;

            newNode = upNode;
            currentLevel++;
        }

        size++;

    }

    public void dumpSkipList() {
        Node temp = head;
        int i = height + 1;
        while (temp != null) {
            System.out.printf("Total [%d] height [%d]", height + 1, i--);
            Node node = temp.right;
            while (node.bit == DATA_BIT) {
                System.out.printf("->%d ", node.value);
                node = node.right;
            }
            System.out.printf("\n");
            temp = temp.down;
        }
        System.out.println("===================================");
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SimpleSkipList<Integer> skipList = new SimpleSkipList<>();
        skipList.add(10);
        skipList.dumpSkipList();

        skipList.add(1);
        skipList.dumpSkipList();

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            skipList.add(random.nextInt(1000));
        }

        skipList.dumpSkipList();

        System.out.println("========"+skipList.get(998));
    }

}
