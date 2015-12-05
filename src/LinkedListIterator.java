public class LinkedListIterator<E> {
    private ListNode<E> _current = null;
    private LinkedList<E> _list = null;

    public LinkedListIterator(LinkedList<E> list) {
        _list = list;
    }

    public E next() {
        if (!hasNext()) {
            return null;
        }
        _current = (_current == null) ? _list.head : _current.next;
        return _current.value;
    }

    public boolean hasNext() {
        if (_list.size == 0) {
            return false;
        }
        if (_current == null) {
            return true;
        }
        return _current.hasNext();
    }

    public E previous() {
        if (!hasPrevious()) {
            return null;
        }
        _current = _current.previous;
        return _current.value;
    }

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