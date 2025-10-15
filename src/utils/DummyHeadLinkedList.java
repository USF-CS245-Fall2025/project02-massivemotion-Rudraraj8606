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

    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("not allowed 🙅‍♂️!");
        }
    }

    private Node<T> findNode(int index){ // will return one before index position node
        Node<T> prev = dummy; // because of this reason
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev;
    }

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

    private Node<T> find(int index){
        Node<T> cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return find(index).data;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        Node<T> beforeNode = findNode(index);
        Node<T> target = beforeNode.next;
        beforeNode.next = target.next;
        size--;
        return target.data;
    }

    @Override
    public int size() {
        return size;
    }
}
