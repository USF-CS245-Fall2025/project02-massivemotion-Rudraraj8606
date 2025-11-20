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
     * insert element at a specific position
     * @param index the position to add the data
     * @param element the data to add at the position
     */
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

    /**
     * Returns the node at the specified index
     * @param index the index of the node to retrieve
     * @return the node at the given index
     */
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

    /**
     * appends the specified element to the end of the list
     * @param element data to add
     * @return boolean
     */
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

    /**
     * returns the element at the specified position in this list
     * @param index the position to retrieve the data
     * @return T
     */
    @Override
    public T get(int index) {
        return nodeAt(index).data;
    }

    /**
     * removes the element at the specified position in this list
     * @param index the position to remove the data
     * @return the element
     */
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

    /**
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }
}
