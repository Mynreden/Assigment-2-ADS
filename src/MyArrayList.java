import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private Object[] array = new Object[10]; // contains objects of list
    private int size = 0; // current size of ArrayList

    @Override
    public int size() { // returned size of ArrayList
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

    class MyIterator<T> implements Iterator<T>{

        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
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
