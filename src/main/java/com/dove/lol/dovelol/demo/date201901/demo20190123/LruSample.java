package com.dove.lol.dovelol.demo.date201901.demo20190123;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Dovelol
 * @date 2019/1/23 21:52
 */
public class LruSample<k, v> implements Iterable<k> {

    private Node head;

    private Node tail;

    private HashMap<k, Node> map;

    private int maxSize;

    public LruSample(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    private class Node {

        Node pre;

        Node next;

        k k;

        v v;

        public Node(k k, v v) {
            this.k = k;
            this.v = v;
        }
    }

    public v get(k key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);

        unlink(node);

        appendHead(node);

        return node.v;
    }

    public void put(k key, v value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if (map.size() > maxSize) {
            Node tailNode = removeTail();
            map.remove(tailNode.k);
        }


    }

    private Node removeTail() {
        Node node = tail.pre;

        Node pre = node.pre;

        tail.pre = pre;

        pre.next = null;

        node.next = null;
        node.pre = null;

        return node;
    }


    private void appendHead(Node node) {
        Node next = head.next;

        node.next = next;

        next.pre = node;

        node.pre = head;

        head.next = node;

    }

    private void unlink(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;

        next.pre = pre;

        node.pre = null;
        node.next = null;


    }


    @Override
    public Iterator<k> iterator() {
        return null;
    }
}
