

public class MyHashMap<V,K> {

    private Node<V,K> last;
    private Node<V,K> first;
    private int size;

    public void put(V value, K key) {
        final Node<V,K> l = last;
        final Node<V,K> newNode = new Node<>(l, value, key, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void remove(Object key) {
        final Node<V,K> e = get(key);

        final V elementValue = e.value;
        final K elementKey = e.key;
        final Node<V,K> next = e.next;
        final Node<V,K> prev = e.prev;

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

        e.key = null;
        e.value = null;
        size--;

    }

    public Node<V,K> get(Object key) {

        Node<V,K> x = first;
        for (int i = 0; i < size; i++)
            if (key.equals(x.key)) {
                return x;
            } else {
                x = x.next;
            }
        return x;
    }


    public void clear() {
        for (Node<V,K> c = first; c != null; ) {
            Node<V,K> next = c.next;
            c.key = null;
            c.value = null;
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


    private static class Node<V,K> {
        K key;
        V value;
        Node<V,K> next;
        Node<V,K> prev;

        Node(Node<V,K> prev, V value, K key, Node<V,K> next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
