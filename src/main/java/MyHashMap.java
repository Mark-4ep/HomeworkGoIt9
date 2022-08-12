

public class MyHashMap<K,V> {

    private Node<K,V> last;
    private Node<K,V> first;
    private int size;

    public void put(V value, K key) {
        final Node<K,V> l = last;
        final Node<K,V> newNode = new Node<>(l, value, key, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void remove(Object key) {
        final Node<K,V> e = get(key);

        final V elementValue = e.value;
        final K elementKey = e.key;
        final Node<K,V> next = e.next;
        final Node<K,V> prev = e.prev;

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

    public Node<K,V> get(Object key) {

        Node<K,V> x = first;
        for (int i = 0; i < size; i++)
            if (key.equals(x.key)) {
                return x;
            } else {
                x = x.next;
            }
        return x;
    }


    public void clear() {
        for (Node<K,V> c = first; c != null; ) {
            Node<K,V> next = c.next;
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


    private static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> prev;

        Node(Node<K,V> prev, V value, K key, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
