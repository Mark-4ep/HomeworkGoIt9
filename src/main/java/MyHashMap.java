

public class MyHashMap<K,V> {

    private Node<K,V> last;
    private Node<K,V> first;
    private int size;

    private Node<K,V> getNode;

    public void put(K key, V value) {
        if (get(key) == null) {
            final Node<K,V> l = last;
            final Node<K,V> newNode = new Node<>(l, key, value, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
        }else if(getNode.key.equals(key)) {
            getNode.value = value;
        }
    }

    public void remove(Object key) {
        get(key);
        final Node<K,V> e = getNode;

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

    public Object get(Object key) {
        Object resulGet = new Object();
        getNode = first;
        for (int i = 0; i < size; i++)
            if (key.equals(getNode.key)) {
                return resulGet = getNode.value;
            } else {
                getNode = getNode.next;
        }
        return null;
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
        int hash;
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> prev;

        Node(Node<K,V> prev, K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
