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
            return (T) get(cursor++);
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
    public boolean addAll(Collection c) { // add elements from collection to ArrayList
        return addAll(size(), c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) { // add elements from collection to ArrayList at specific index
        for (Object element: c){
            add(index++, element);
        }
        size += c.size();
        return true;
    }

    @Override
    public void clear() { // clear ArrayList: deleted all elements and size become equal zero
        size = 0;
        array = new Object[10];
    }

    @Override
    public T get(int index) { // get element in specific index
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    @Override
    public Object set(int index, Object element) { // set element at specific index
        if (index >= size) throw new IndexOutOfBoundsException();
        array[index] = element;
        return element;
    }

    @Override
    public void add(int index, Object element) { // adding element at specific index
        if (size == array.length) increaseArray();
        for (int i = index; i < size; i ++){
            array[i + 1] = array[i];
        }
        array[index] = element;
        size ++;
    }

    @Override
    public T remove(int index) { // remove element by it index
        T temp = get(index);
        for (int i = index; i < size; i ++){
            array[i] = array[i + 1];
        }
        size --;
        return temp;
    }

    @Override
    public int indexOf(Object o) { // find index of object, if object does not exist in array return -1
        for (int i = 0; i < size; i ++){
            if (array[i].equals(o)) return i;
        }
        return -1;
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
