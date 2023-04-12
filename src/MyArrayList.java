import java.util.*;

public class MyArrayList<T> implements List<T> {
    private Object[] array = new Object[10]; // contains objects of list
    private int size = 0; // current size of ArrayList

    @Override
    public int size() { // return size of ArrayList
        return size;
    }

    @Override
    public boolean isEmpty() { // check if ArrayList is empty
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) { // check is ArrayList contain object
        for (int i = 0;i < size; i ++){
            if (array[i] == o) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator<T>();
    }

    class MyIterator<T> implements Iterator<T>{ // class used for iterating in ArrayList

        private int cursor = 0; // pointer to the current object
        @Override
        public boolean hasNext() { // check is ArrayList has next element after cursor
            return cursor < size();
        }

        @Override
        public T next() { // getting next element after cursor
            return get(cursor++);
        }

        @Override
        public void remove() { // remove element at cursor
            MyArrayList.this.remove(cursor);
        }
    }


    @Override
    public Object[] toArray() { // returns array from ArrayList
        Object[] temp = new Object[size()];
        for (int i = 0; i < size; i ++){
            temp[i] = array[i];
        }
        return temp;
    }

    @Override
    public boolean add(Object o) { // adding new element to ArrayList
        if (size() == array.length) increaseArray();
        array[size] = o;
        size++;
        return true;
    }

    private void increaseArray(){ // increasing size of array attribute to double size
        Object[] temp = new Object[size * 2];
        for (int i = 0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public boolean remove(Object o) { // remove one element from ArrayList
        MyIterator<T> iterator = new MyIterator<>();
        while (iterator.hasNext()){
            if (iterator.next().equals(o)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return addAll(size(), c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        for (Object element: c){
            add(index++, element);
        }
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
