import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<T extends Comparable> implements MyList<T>, Iterable<T> {

    private Node<T> head; // pointer to first node
    private Node<T> tail; // pointer to last node
    private int size = 0; // size of LinkedList
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

        @Override
        public String toString() {
            return data.toString();
        }
    }

    @Override
    public int size() { // size of linked list
        return size;
    }

    @Override
    public boolean contains(Object o) { // check is linked list contain object
        for (T object : this){
            if (object.equals(o)) return true;
        }
        return false;
    }

    @Override
    public void add(T item) { // adding object to the end of linked list
        add(item, size());
    }

    @Override
    public void add(T item, int index) { // add element to linkedList
        if (index > size) throw new IndexOutOfBoundsException();
        Node<T> temp = new Node<>(item);
        size ++;
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        if (index == 0) {
            connectToStart(temp);
            return;
        }
        if (index + 1 != size()) {
            connectToMiddle(temp, index);
            return;
        }

        connectToEnd(temp);
    }

    private void connectToStart(Node<T> temp){
        temp.next = head;
        head.previous = temp;
        head = temp;
    }

    private void connectToMiddle(Node<T> temp, int index){
        Node<T> prev = getNode(index - 1);
        Node<T> next = getNode(index);
        prev.next = temp;
        temp.previous = next;
        next.previous = temp;
        temp.next = next;
    }

    private void connectToEnd(Node<T> temp){
        tail.next = temp;
        temp.previous = tail;
        tail = temp;
    }

    @Override
    public boolean remove(T item) { // remove element from LinkedList
        int i = 0;
        for (T object: this){
            if (object.equals(item)){
                remove(i);
                return true;
            }
            i ++;
        }
        return false;
    }

    @Override
    public T remove(int index) { // remove element by index
        T temp = get(index);
        if (index == 0) {
            head = head.next;
            if (size > 1) head.previous = null;
        }
        else if (index == size) {
            tail = tail.previous;
            if (size > 2) tail.next = null;
        }
        else {
            Node<T> prev = getNode(index - 1);
            Node<T> next = getNode(index + 1);
            prev.next = next;
            next.previous = prev;
        }
        size--;
        return temp;
    }

    @Override
    public void clear() { // clear all Linked list
        head = null;
        size = 0;
        tail = null;
    }

    @Override
    public T get(int index) { // get element by its index
        if (index >= size) throw new IndexOutOfBoundsException();
        int i = 0;
        for (T object : this){
            if (i == index) return object;
            i ++;
        }
        return null;
    }

    public Node<T> getNode(int index){ // get node by it index
        if (index >= size) throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        int i = 0;
        while (temp != null){
            if (i == index) return temp;
            i ++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) { // find first index of element. If it is not exist return -1
        int i = 0;
        for (T object: this){
            if (object.equals(o)) return i;
            i ++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) { // find last index of object in linkedList. If it is not exist return -1
        Node<T> object = tail;
        int i = size - 1;
        while (object != null){
            if (object.getData().equals(o)) return i;
            i --;
            object = object.previous;
        }
        return -1;
    }

    @Override
    public void sort() {
        quickSort(head, tail);
    }

    private int indexOfNode(Node<T> node){ // find index of node
        int i = 0;
        Node<T> a = head;
        while(a != null){
            if (a == node) return i;
            i ++;
            a = a.getNext();
        }
        return -1;
    }

    private void quickSort(Node<T> left, Node<T> right){ // quicksort for linked list
        if (indexOfNode(left) >= indexOfNode(right)) return;
        Node<T> less = Partition(left, right);
        quickSort(left, less.previous);
        quickSort(less.next, right);
    }

    private Node<T> Partition(Node<T> head, Node<T> tail) {
        T opora = tail.getData();
        Node<T> less = head;
        Node<T> i = head;

        while (i != tail){
            if (i.getData().compareTo(opora) < 1){
                T temp = i.getData();
                i.setData(less.getData());
                less.setData(temp);

                less = less.next;
            }
            i = i.next;
        }

        T temp = tail.getData();
        tail.setData(less.getData());
        less.setData(temp);
        return less;
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
        Object[] array = new Object[size];
        int i = 0;
        for (T object: this){
            array[i] = object;
            i ++;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
