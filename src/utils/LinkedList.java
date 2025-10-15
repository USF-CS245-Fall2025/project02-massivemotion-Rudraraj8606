package utils;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    // inner class Node
    static class Node<T>{
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // constructor
    public LinkedList() {
        this.head = null;
        size = 0;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("not allowed !");
        }
    }

    @Override
    public void add(int index, T element) {
        rangeCheck(index);
        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public boolean add(T element) {
        if(head == null){
            head = new Node<>(element);
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(element);
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public T remove(int index) {
        if (index == 0) {
            T val = head.data;
            head = head.next;
            size--;
            return val;
        }
        Node<T> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node<T> target = prev.next;
        T val = target.data;
        prev.next = target.next;
        size--;
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
