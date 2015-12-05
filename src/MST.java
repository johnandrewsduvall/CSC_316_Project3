public class MST<E> {
    private E _start = null;
    private LinkedList<Vertex<E>> _from = null;
    private LinkedList<Vertex<E>> _to = null;
    public int size;

    public MST(LinkedList<Vertex<E>> from, LinkedList<Vertex<E>> to) {
        _from = from;
        _to = to;
        _start = _to.head.value.key;
        this.size = _to.size;
    }

    public LinkedList<E> getPath(E to) {
        LinkedList<E> path = new LinkedList<E>();
        E search = to;
        ListNode<Vertex<E>> currentTo = null;
        ListNode<Vertex<E>> currentFr = null;
        do {
            currentTo = currentTo == null ? _to.tail : currentTo.previous;
            currentFr = currentFr == null ? _from.tail : currentFr.previous;
            if (currentTo.value.key == search) {
                path.prepend(search);
                if (search == _start) {
                    return path;
                }
                search = currentFr.value.key;
            }
        } while (currentTo.hasPrevious());

        // Couldn't trace a full path
        return null;
    }

    public double getConnectivityRating(int visitID) {
        if (this.size == 0) {
            return 0;
        } else if (this.size == 1) {
            return 1;
        }

        double pathLengthSum = 0;
        _to.head.value.visitID = 0;

        LinkedListIterator<Vertex<E>> toIt = _to.iterator();
        LinkedListIterator<Vertex<E>> frIt = _from.iterator();
        while (toIt.hasNext()) {
            Vertex<E> to = toIt.next();
            Vertex<E> fr = frIt.next();
            if (to.key != _start) {
                to.visitID = fr.visitID + 1;
                pathLengthSum += to.visitID;
            }
        }

        return (this.size - 1) / pathLengthSum;
    }
}