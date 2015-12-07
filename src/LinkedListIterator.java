/**
 * @author Matthew Watkins, Shujen Ye, John Andrew Duvall
 * @param <E>
 * The iterator class composed in the LinkedList class
 */
public class LinkedListIterator<E> {
    /** current node of ListNode */
    private ListNode<E> _current = null;
    /** list of LinkedList */
    private LinkedList<E> _list = null;
    
    /**
     * Constructor method.
     * @param list of LinkedList
     */
    public LinkedListIterator(LinkedList<E> list) {
        _list = list;
    }

    /**
     * next method.
     * @return the current value of next method.
     */
    public E next() {
        if (!hasNext()) {
            return null;
        }
        _current = (_current == null) ? _list.head : _current.next;
        return _current.value;
    }

    /**
     * hasNext method.
     * @returna boolean of a result.
     */
    public boolean hasNext() {
        if (_list.size == 0) {
            return false;
        }
        if (_current == null) {
            return true;
        }
        return _current.hasNext();
    }

    /**
     * previous method.
     * @return value of previous value.
     */
    public E previous() {
        if (!hasPrevious()) {
            return null;
        }
        _current = _current.previous;
        return _current.value;
    }

    /**
     * hasPrevious method.
     * @return a boolean of result
     */
    public boolean hasPrevious() {
        if (_list.size == 0) {
            return false;
        }
        if (_current == null) {
            return false;
        }
        return _current.hasPrevious();
    }
}