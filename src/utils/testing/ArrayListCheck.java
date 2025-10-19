package utils.testing;

import utils.ArrayList;

public class ArrayListCheck {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        // adding
        for (int i = 0; i < 10; i++) {
            System.out.print(data.add(i));
        }
        System.out.println();
        System.out.println("-".repeat(20));

        //retrieve
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i)+";");
        }
        System.out.println();
        System.out.println("-".repeat(20));

        //delete something
        System.out.println(data.get(1)); // must print 1
        data.remove(1); // removing 1
        System.out.println(data.get(1)); // must print 2
        System.out.println("-");
        System.out.println(data.get(8)); // must print 9
        data.remove(8); // must remove 9
        System.out.println(data.get(8)); // must be null

        //delete everything
//        for (int i = 0; i < data.size(); i++) {
//            data.remove(i);
//        }
        while (data.size() > 0) {
            data.remove(data.size()-1);
        }
        System.out.println();
        System.out.println("-".repeat(20));

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        // printing
        System.out.println("final size -> " + data.size());
    }
}
