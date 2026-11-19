class MyHashMap {
    LinkedList<Node>[] store;
    int size, element;
    final double threshold = 0.75; 
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        size = 5;
        element = 0;
        store = new LinkedList[size];
        for (int i = 0; i < size; i++) 
            store[i] = new LinkedList<>();
    }
    
    public void put(int key, int value) {
        int idx = Integer.hashCode(key)%size;
        LinkedList<Node> cur = store[idx];
        boolean exit = false;
        for(Node c : cur){
            if(c.key == key){
                c.value = value;
                exit = true;
                return;
            }
        }
        if (!exit) {
            cur.add(new Node(key, value));
            element++;
            if ((double)element/size > threshold) {
                rehash();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public void rehash(){
        LinkedList<Node>[] old = store;
        size = size * 2;
        store = new LinkedList[size];
        for (int i = 0; i < size; i++) 
            store[i] = new LinkedList<>();
        for(LinkedList<Node> cur : old) 
            for (Node node : cur)
                put(node.key, node.value);
    }

    public int get(int key) {
        int idx = Integer.hashCode(key) % size;
        LinkedList<Node> cur = store[idx];
        if (cur.isEmpty() || cur == null) 
            return -1;

        for(Node node : cur){
            if(node.key == key) return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        
        int idx = Integer.hashCode(key) % size;
        LinkedList<Node> cur = store[idx];
        if(cur == null || cur.isEmpty()) return;
        for(Node node : cur){ 
            if(node.key == key) { 
                cur.remove(node);
                return;
            }
        }
    

    }
}
class Node {
    int key, value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}