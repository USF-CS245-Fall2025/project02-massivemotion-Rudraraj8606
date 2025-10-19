package utils.testing;

import utils.DoublyLinkedList;

public class DoublylinkedListCheck {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> data = new DoublyLinkedList<>();

        // add
        for (int i = 0; i <= 10; i++) {
            System.out.print(data.add(i));
        }
        System.out.println();
        System.out.println("-".repeat(20));

        // retrieve
        System.out.println(data.get(4)); // must print 4
        System.out.println("-".repeat(20));

        // delete something
        data.remove(4); // delete 4

        // retrieve
        System.out.println(data.get(4));
        System.out.println("-".repeat(20));

        // delete everything
        while (data.size() > 0) {
            data.remove(data.size()-1);
        }

        // final size
        System.out.println("final size -> "+data.size());

    }
}
