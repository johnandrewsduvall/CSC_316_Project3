/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * @param <E> Objects type for the list.
 * +
 */
public class LinkedList<E> {
    public ListNode<E> head;
    public ListNode<E> tail;
    public int size;

    /**
     *
     * @param value
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
     *
     * @param value
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
     *
     * @return
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
     *
     * @param value
     * @return
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