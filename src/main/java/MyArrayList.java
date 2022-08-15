import java.util.Arrays;

class MyArrayList<E> {

    private Object[] info = new Object[1];
    private int index = 0;


    public void add(E value) {
        info[index++] = value;
        info = Arrays.copyOf(info, info.length + 1);
    }

    public void remove(int index) {
        int j = 0;
        Object[] corektInfo = new Object[info.length - 1];

        for (int i = 0; i < corektInfo.length; i++) {
            if (i != index) {
                corektInfo[j++] = info[i];
            }
        }

        info = Arrays.copyOf(corektInfo, corektInfo.length);
        this.index = info.length - 1;
    }
    public void clear() {
        info = new Object[0];
    }

    public int size() {
        return info.length - 1;
    }

    public Object get(int index) {
        return info[index];
    }
}
