

class MyQueue<E> {
    private Node<E> last;
    private Node<E> first;
    private int size;

    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void remove(int index) {
        final Node<E> e = (Node<E>) get(index);

        final E element = e.item;
        final Node<E> next = e.next;
        final Node<E> prev = e.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            e.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            e.next = null;
        }

        e.item = null;
        size--;

    }

    public void clear() {
        for (Node<E> c = first; c != null; ) {
            Node<E> next = c.next;
            c.item = null;
            c.next = null;
            c.prev = null;
            c = next;
        }
        first = last = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(int index) {
        Object resulGet = new Object();

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return resulGet = x.item;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return resulGet = x.item;
        }
    }

    public Object peek() {
        return get(size());}

    public Object poll() {
        final Object pollRemove = peek();
        remove(size());
        return pollRemove;
    }



    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
