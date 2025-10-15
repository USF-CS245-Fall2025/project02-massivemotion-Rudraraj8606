package utils;

public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // inner class
    static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            prev = next = null;
        }
    }

    // constructor
    public DoublyLinkedList(){
        this.head = this.tail = null;
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
        if(index == size){ // adding it at the end
            add(element);
            return;
        }
        if(index == 0){
            Node<T> ele = new Node<>(element);
            ele.next = head;
            if (head != null) {
                head.prev = ele;
            }
            head = ele;
            if (tail == null) { // list was empty
                tail = ele;
            }
            size++;
            return;
        }

        Node<T> after = nodeAt(index);   // locate the node at that index
        Node<T> before = after.prev;
        Node<T> n = new Node<>(element);

        n.prev = before;
        n.next = after;
        before.next = n;
        after.prev = n;

        size++;
    }

    private Node<T> nodeAt(int index){
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public boolean add(T element) {
        Node<T> ele = new Node<>(element);
        if(head == null){
            head = tail = ele;
        }
        ele.prev = tail;
        tail.next = ele;
        tail = ele;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        return nodeAt(index).data;
    }

    @Override
    public T remove(int index) {
        Node<T> ele = nodeAt(index);
        T val = ele.data;
        Node<T> before = ele.prev;
        Node<T> after = ele.next;
        if (before == null) { // removing head
            head = after;
        } else {
            before.next = after;
        }
        if (after == null) { // removing tail
            tail = before;
        } else {
            after.prev = before;
        }
        size--;
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
