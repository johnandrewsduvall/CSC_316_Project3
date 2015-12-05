public class ListNode<E> {
    public E value;
    public ListNode<E> previous;
    public ListNode<E> next;

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    public ListNode(E value) {
        this.value = value;
    }
}