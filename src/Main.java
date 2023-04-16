import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //testArrayList();
        testLinkedList();
    }

    private static void testLinkedList(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(22); // adding values
        linkedList.add(1);
        linkedList.add(18);
        linkedList.add(2);
        linkedList.add(75);
        linkedList.add(8);
        linkedList.add(0);
        linkedList.add(55);
        linkedList.add(1);
        linkedList.add(63);
        System.out.println("Elements in array: " + linkedList);
        System.out.println("Size: " + linkedList.size()); // check size
        linkedList.add(99,4); // add by index
        System.out.println("After adding '99' at index 4:" + linkedList);
        System.out.println("Is LinkedList contain '55'?: " + linkedList.contains(55));
        System.out.println("Iteration: ");
        for (Integer a : linkedList){ // iterator check
            System.out.printf("%s, ", a);
        }
        linkedList.remove(4); // remove element with index 4
        System.out.println("\nAfter removing fifth element: " + linkedList);

        Integer a = 55;
        linkedList.remove(a); // remove element Integer(55)
        System.out.println("After removing element '55': " + linkedList);

        System.out.println("Index of element '8': " + linkedList.indexOf(8)); // find index of element Integer(8)

        linkedList.sort(); // sorting list
        System.out.println("Sorted array: " + linkedList);
    }

    private static void testArrayList(){
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1); // adding values
        arrayList.add(7);
        arrayList.add(18);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(0);
        arrayList.add(55);
        arrayList.add(1);
        arrayList.add(63);
        System.out.println("Elements in array: " + arrayList);
        System.out.println("Size: " + arrayList.size()); // check size
        arrayList.add(99,4); // add by index
        System.out.println("After adding '99' at index 4:" + arrayList);
        System.out.println("Is ArrayList contain '55'?: " + arrayList.contains(55));
        System.out.println("Iteration: ");
        for (Integer a : arrayList){ // iterator check
            System.out.printf("%s, ", a);
        }
        arrayList.remove(4); // remove element with index 4
        System.out.println("\nAfter removing fifth element: " + arrayList);

        Integer a = 55;
        arrayList.remove(a); // remove element Integer(55)
        System.out.println("After removing element '55': " + arrayList);

        System.out.println("Index of element '8': " + arrayList.indexOf(8)); // find index of element Integer(8)

        arrayList.sort(); // sorting array
        System.out.println("Sorted array: " + arrayList);
    }
}