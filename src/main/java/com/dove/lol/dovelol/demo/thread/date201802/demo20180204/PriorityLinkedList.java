package com.dove.lol.dovelol.demo.thread.date201802.demo20180204;

/**
 * @author Dovelol
 * @date 2018/2/4 17:59
 */
public class PriorityLinkedList<E extends Comparable<E>> {

    private Node<E> first;

    private final Node<E> NULL = (Node<E>) null;

    private static final String PLAIN_NULL = "NULL";

    private int size;

    public PriorityLinkedList() {
        this.first = NULL;
    }

    private int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static <E extends Comparable<E>> PriorityLinkedList<E> of(E... elements) {
        final PriorityLinkedList<E> list = new PriorityLinkedList<>();
        if (elements.length != 0) {
            for (E e : elements) {
                list.addFirst(e);
            }
        }
        return list;

    }

    public PriorityLinkedList<E> addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        Node<E> previous = NULL;
        Node<E> current = first;
        while (current != null && e.compareTo(current.value) > 0) {
            previous = current;
            current = current.next;
        }
        if (previous == NULL) {
            first = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
        this.size++;
        return this;
    }

    public boolean contains(E e) {
        Node<E> current = first;
        while (current != null) {
            if (current.value == e) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            throw new NoElementException("no data");
        }
        Node<E> node = first;
        first = node.next;
        size--;
        return node.value;

    }

    public E remove(E e) {
        if (this.isEmpty()) {
            throw new NoElementException("no data");
        }
        Node<E> node = first;
        Node<E> temp = node;
        while (node != null) {
            if (node.value == e) {
                if (node == temp) {
                    first = node.next;
                } else if (node.next == NULL) {
                    temp.next = NULL;
                } else {
                    temp.next = node.next;
                }
                size--;
                return node.value;
            }
            temp = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder("[");
            Node<E> current = first;
            while (current != null) {
                builder.append(current.toString()).append(",");
                current = current.next;
            }
            builder.replace(builder.length() - 1, builder.length(), "]");
            return builder.toString();
        }
    }

    static class NoElementException extends RuntimeException {

        public NoElementException(String message) {
            super(message);
        }
    }

    private static class Node<E> {
        E value;

        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(PriorityLinkedList.of(5,11,2,1,100,-10,88,66));
    }

}
