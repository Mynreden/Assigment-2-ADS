import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        testArrayList();

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

        arrayList.remove(new Integer(55)); // remove element Integer(55)
        System.out.println("After removing element '55': " + arrayList);

        System.out.println("Index of element '8': " + arrayList.indexOf(8)); // find index of element Integer(8)

        arrayList.sort(); // sorting array
        System.out.println("Sorted array: " + arrayList);
    }
}