package utils;

public class DummyHeadLinkedList<T> implements List<T> {
    private Node<T> dummy;
    private int size;

    //inner class
    static class Node<T>{
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //constructor
    public DummyHeadLinkedList(){
        this.dummy = new Node<>(null);
        this.size = 0;
    }

    /**
     * checks the range of the given input
     * throws the error if not in a particular range
     * time complexity O(1)
     * @param index
     */
    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("not allowed 🙅‍♂️!");
        }
    }

    /**
     * returns the node just before the node at the specified index
     * @param index position to find
     * @return the node at that position
     */
    private Node<T> findNode(int index){ // will return one before index position node
        Node<T> prev = dummy; // because of this reason
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev;
    }

    /**
     * inserts the specified element at the specified position in this linked list
     * @param index the position to insert the element
     * @param element the data
     */
    @Override
    public void add(int index, T element) {
        rangeCheck(index);
        Node<T> oneBeforeNode = findNode(index);
        Node<T> ele = new Node<>(element);
        ele.next = oneBeforeNode.next;
        oneBeforeNode.next = ele;
        size++;
    }

    @Override
    public boolean add(T element) {
        add(size, element);
        return true;
    }

    /**
     * returns the node at the specified index
     * @param index the position
     * @return node at the position
     */
    private Node<T> find(int index){
        Node<T> cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * returns the element at the specified position in this list
     * @param index the position
     * @return T
     */
    @Override
    public T get(int index) {
        rangeCheck(index);
        return find(index).data;
    }

    /**
     * removes the element at the specified position in this list
     * @param index teh position
     * @return T
     */
    @Override
    public T remove(int index) {
        rangeCheck(index);
        Node<T> beforeNode = findNode(index);
        Node<T> target = beforeNode.next;
        beforeNode.next = target.next;
        size--;
        return target.data;
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
