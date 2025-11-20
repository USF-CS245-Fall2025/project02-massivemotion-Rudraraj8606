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

    /**
     * checks the range of the given input
     * throws the error if not in a particular range
     * time complexity O(1)
     * @param index
     */
    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("not allowed !");
        }
    }

    /**
     * inserts the element at the specified position in this list
     * @param index the position
     * @param element the data to add
     */
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

    /**
     * adds the specified element to the end of this list
     * @param element the data
     * @return boolean
     */
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

    /**
     * returns the element at the specified position in this list
     * @param index the position
     * @return T
     */
    @Override
    public T get(int index) {
        rangeCheck(index);
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * removes the element at the specified position in this list
     * @param index the position
     * @return T
     */
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

    /**
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }
}
