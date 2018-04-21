package com.dove.lol.dovelol.demo.thread.date201802.demo20180204;

/**
 * @author Dovelol
 * @date 2018/2/4 17:16
 */
public class LinkedList<E> {

    private Node<E> first;

    private final Node<E> NULL = (Node<E>) null;

    private static final String PLAIN_NULL = "NULL";

    private int size;

    public LinkedList() {
        this.first = NULL;
    }

    private int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static <E> LinkedList<E> of(E... elements) {
        final LinkedList<E> list = new LinkedList<>();
        if (elements.length != 0) {
            for (E e : elements) {
                list.addFirst(e);
            }
        }
        return list;

    }

    public LinkedList<E> addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        newNode.next = first;

        this.size++;
        this.first = newNode;
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
        LinkedList<String> linkedList = LinkedList.of("d", "o", "v", "e");
        linkedList.addFirst("lol").addFirst("hello");
        System.out.println(linkedList.size);
        System.out.println(linkedList);
        System.out.println("=======");
        System.out.println(linkedList.contains("hello"));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.contains("hello"));
        System.out.println(linkedList);
        System.out.println("=======");
        System.out.println(linkedList.contains("lol"));
        System.out.println(linkedList.remove("lol"));
        System.out.println(linkedList.contains("lol"));
        System.out.println(linkedList.size);
        System.out.println(linkedList);
        System.out.println("=======");
        System.out.println(linkedList.contains("a"));
        System.out.println(linkedList.remove("a"));
        System.out.println(linkedList.contains("a"));
        System.out.println(linkedList.size);
        System.out.println(linkedList);
        System.out.println("=======");
        while (!linkedList.isEmpty()){
            System.out.println(linkedList.removeFirst());
        }


    }

}
