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

        /*
        LinkedListIterator<Vertex<E>> frIt = _from.iterator();
        while (frIt.hasNext()) {
            Vertex<E> next = frIt.next();
            if (next == null || next.key == null) {
                System.out.print("- ");
            } else {
                System.out.print(next.key + " ");
            }
        }
        System.out.println();

        LinkedListIterator<Vertex<E>> toIt = _to.iterator();
        while (toIt.hasNext()) {
            System.out.print(toIt.next().key + " ");
        }
        System.out.println();
        */
    }

    public LinkedList<E> getPath(E to) {
        LinkedList<E> path = new LinkedList<E>();
        E search = to;
        ListNode<Vertex<E>> currentTo = null;
        ListNode<Vertex<E>> currentFr = null;

        do {
            currentTo = currentTo == null ? _to.tail : currentTo.previous;
            currentFr = currentFr == null ? _from.tail : currentFr.previous;
            if (currentTo.value.key.equals(search)) {
                path.prepend(search);
                if (search.equals(_start)) {
                    return path;
                }
                search = currentFr.value.key;
            }
        } while (currentTo.hasPrevious());

        // Couldn't trace a full path
        return null;
    }

    public double getConnectivityRating() {
        if (this.size <= 0) {
            return 0;
        }

        double pathLengthSum = 0;
        _to.head.value.cumulativeLen = 0;

        LinkedListIterator<Vertex<E>> toIt = _to.iterator();
        LinkedListIterator<Vertex<E>> frIt = _from.iterator();
        while (toIt.hasNext()) {
            Vertex<E> to = toIt.next();
            Vertex<E> fr = frIt.next();
            if (to.key != _start) {
                to.cumulativeLen = fr.cumulativeLen + 1;
                pathLengthSum += to.cumulativeLen;
            }
        }

        return (this.size - 1) / pathLengthSum;
    }
}