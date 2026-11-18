class MyHashSet {
    List<LinkedList<Integer>> store;
    int size;
    int element;
    int limit = 2;

    public MyHashSet() {
        size = 5;
        store = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            store.add(new LinkedList<>());
        }
    }

    public void rehash() {
        List<LinkedList<Integer>> old = store;
        size = size * 2;
        store = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            store.add(new LinkedList<>());
        }
        element = 0;
        for (LinkedList<Integer> cur : old) {
            for (Integer v : cur) add(v);
        }
    }

    public void add(int key) {
        int idx = Integer.hashCode(key) % size;
        LinkedList<Integer> cur = store.get(idx);
        if (cur != null && !cur.contains(key)) {
            cur.add(key);
            element++;
        }
        int curLimit = element / size;
        if (curLimit > limit) {
            rehash();
        }
    }

    public void remove(int key) {
        int idx = Integer.hashCode(key) % size;
        LinkedList<Integer> cur = store.get(idx);
        if (cur == null || cur.isEmpty() || !cur.contains(key)) {
            return;
        } else {
            cur.remove(Integer.valueOf(key));
            element--;
        }
    }

    public boolean contains(int key) {
        int idx = Integer.hashCode(key) % size;
        LinkedList<Integer> cur = store.get(idx);
        if (cur != null && !cur.isEmpty() && cur.contains(key)) {
            return true;
        }
        return false;
    }
}