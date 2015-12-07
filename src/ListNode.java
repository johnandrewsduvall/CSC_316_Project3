/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * @param <E> 
 * The generic node class with methods to act upon it.
 */
public class ListNode<E> {
    /** value of node */
    public E value;
    /** previous value of ListNode */
    public ListNode<E> previous;
    /** next value of ListNode */
    public ListNode<E> next;

    /**
     * hasNext method
     * @return a boolean of result
     */
    public boolean hasNext() {
        return next != null;
    }

    /**
     * hasPrevious method
     * @return a boolean of result
     */
    public boolean hasPrevious() {
        return previous != null;
    }

    /**
     * Constructor method.
     * @param value value of node
     */
    public ListNode(E value) {
        this.value = value;
    }
}