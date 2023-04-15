import java.util.Iterator;

public class MyLinkedList<T extends Comparable> implements MyList<T>, Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data){
            this.data = data;
        }

        public Node(E data, Node<E> previous){
            this.data = data;
            this.previous = previous;
        }

        public Node(E data, Node<E> next, Node<E> previous){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public boolean equals(Node<E> obj) {
            return data.equals(obj.getData());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(T item) {
        size ++;
        Node<T> temp = new Node<>(item);
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        temp.previous = tail;
        tail = temp;
    }

    @Override
    public void add(T item, int index) {
        if (index > size) throw new IndexOutOfBoundsException();


    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        int i = 0;

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
    public void sort() {

    }

    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    private class MyIterator<E> implements Iterator<E>{ // class used for iterating in ArrayList
        private Node<T> cursor = head; // pointer to the current object

        @Override
        public boolean hasNext() { // check is LinkedList has next element after cursor
            return cursor != null;
        }

        @Override
        public E next() { // getting next element after cursor
            E temp = (E) cursor.data;
            cursor = cursor.next;
            return temp;
        }

        public Node<T> getCursor(){
            return cursor;
        }
    }

    public Object[] toArray(){
        return new Object[1];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
