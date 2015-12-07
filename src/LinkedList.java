/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * @param <E> Objects type for the list.
 * This is a LinkedList class.
 */
public class LinkedList<E> {
    /** head of a list node */
    public ListNode<E> head;
    /** tail of a list node */
    public ListNode<E> tail;
    /** size of a list*/
    public int size;

    /**
     * Append method.
     * @param value a value of node
     */
    public void append(E value) {
        ListNode<E> node = new ListNode<>(value);
        if (this.head == null) {
            // First node
            this.head = node;
            this.tail = node;
        } else {
            // Consecutive node
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    /**
     * Prepend method.
     * @param value a value of node
     */
    public void prepend(E value) {
        ListNode<E> node = new ListNode<>(value);
        if (this.head == null) {
            // First node
            this.head = node;
            this.tail = node;
        } else {
            // Consecutive node
            this.head.previous = node;
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    /**
     * Iterator method.
     * @return a LinkedListIterator
     */
    public LinkedListIterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }
    
//Unused Method
/*
    public E[] toArray() {
        if (this.size == 0) {
            return (E[])(new Object[0]);
        }

        Object[] arr = new Object[size];
        LinkedListIterator<E> iterator = this.iterator();
        for (int i = 0; i < size; i++) {
            arr[i] = iterator.next();
        }

        return (E[])arr;
    }
*/

    /**
     * Contains method.
     * @param value a value of node
     * @return a boolean of a result, either true of false
     */
    public boolean contains(E value) {
        LinkedListIterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == value) {
                return true;
            }
        }
        return false;
    }
}