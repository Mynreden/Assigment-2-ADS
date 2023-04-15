import java.util.*;

public class MyArrayList<T extends Comparable> implements MyList<T>, Iterable<T>{
    private Object[] array = new Object[10]; // contains objects of list
    private int size = 0; // current size of ArrayList

    public int size() { // return size of ArrayList
        return size;
    }

    public boolean isEmpty() { // check if ArrayList is empty
        return size() == 0;
    }

    public boolean contains(Object o) { // check is ArrayList contain object
        for (int i = 0; i < size; i ++){
            if (array[i].equals(o)) return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<E> implements Iterator<E>{ // class used for iterating in ArrayList

        private int cursor = 0; // pointer to the current object
        @Override
        public boolean hasNext() { // check is ArrayList has next element after cursor
            return cursor < size();
        }

        @Override
        public E next() { // getting next element after cursor
            return (E) get(cursor++);
        }

        public boolean hasPrevious() { // check is ArrayList has next element after cursor
            return hasNext();
        }

        public E previous() { // getting next element after cursor
            cursor++;
            return (E) get(size - cursor);
        }

        @Override
        public void remove() { // remove element at cursor
            MyArrayList.this.remove(cursor - 1);
        }

        public int getCursor(){
            return cursor - 1;
        }
    }

    public Object[] toArray() { // returns array from ArrayList
        Object[] temp = new Object[size()];
        for (int i = 0; i < size; i ++){
            temp[i] = array[i];
        }
        return temp;
    }

    public void add(T o) { // adding new element to ArrayList
        if (size() == array.length) increaseArray();
        array[size] = o;
        size++;
    }

    @Override
    public void add(T item, int index) { // adding new element to ArrayList at specific index
        if (index > size) throw new IndexOutOfBoundsException();
        if (size() == array.length) increaseArray();
        for (int i = size; i >index; i --){
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    private void increaseArray(){ // increasing size of array attribute to double size
        Object[] temp = new Object[size * 2];
        for (int i = 0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
    }

    public boolean remove(T o) { // remove one element from ArrayList
        MyIterator<T> iterator = new MyIterator<>();
        while (iterator.hasNext()){
            if (iterator.next().equals(o)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) { // add elements from collection to ArrayList at specific index
        for (T element: c){
            add(element, index++);
        }
        size += c.size();
        return true;
    }

    public void clear() { // clear ArrayList: deletes all elements and size become equal zero
        size = 0;
        array = new Object[10];
    }

    public T get(int index) { // get element in specific index
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    public Object set(int index, Object element) { // set element at specific index
        if (index >= size) throw new IndexOutOfBoundsException();
        array[index] = element;
        return element;
    }

    public T remove(int index) { // remove element by it index
        T temp = get(index);
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size --;
        array[size] = null;
        return temp;
    }

    public int indexOf(Object o) { // find index of object, if object does not exist in array return -1
        MyIterator<T> iterator = new MyIterator<>();
        while (iterator.hasNext()){
            if (iterator.next().equals(o)) return iterator.getCursor();
        }
        return -1;
    }

    public int lastIndexOf(Object o) { // return index
        MyIterator<T> iterator = new MyIterator<>();
        while (iterator.hasPrevious()){
            if (iterator.previous().equals(o)) return iterator.getCursor();
        }
        return -1;
    }

    @Override
    public void sort() {
        quickSort(array, 0, size() - 1);
    }

    private void quickSort(Object[] arr, int left, int right){
        if (left >= right) return;
        int less = Partition(arr, left, right);
        quickSort(arr, left, less - 1);
        quickSort(arr, less + 1, right);
    }

    private int Partition(Object[] arr, int left, int right) {
        T opora = get(right);
        int less = left;

        for (int i = less; i < right; i ++){
            if (get(i).compareTo(opora) < 1){
                Object temp = arr[i];
                arr[i] = arr[less];
                arr[less] = temp;
                less ++;
            }
        }
        Object temp = arr[right];
        arr[right] = arr[less];
        arr[less] = temp;
        return less;
    }

    @Override
    public String toString() {
        Object[] arr = toArray();
        return Arrays.toString(arr);
    }
}
