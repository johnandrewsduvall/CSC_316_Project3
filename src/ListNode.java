/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * @param <E> 
 */
public class ListNode<E> {
    public E value;
    public ListNode<E> previous;
    public ListNode<E> next;

    /**
     *
     * @return
     */
    public boolean hasNext() {
        return next != null;
    }

    /**
     *
     * @return
     */
    public boolean hasPrevious() {
        return previous != null;
    }

    /**
     *
     * @param value
     */
    public ListNode(E value) {
        this.value = value;
    }
}