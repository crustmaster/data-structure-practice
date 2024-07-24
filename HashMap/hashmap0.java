class hashmap0 {

    /* get definitaion and initialization of myhashmap*/
    private static final int base = 769;
    private Node[] data;  
    public class Node {
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public Node() {
            this.key = 0;
            this.value = 0;
            this.next = null;
        }
    }
    public hashmap0() {
        data = new Node[base];
        for (int i=0; i<base; i++) {
            data[i] = new Node();
        }
    }

    private int hashIndex(int key) {
        return key % base;
    }
    
    public void put(int key, int value) {
        int h = hashIndex(key);
        Node cur = data[h];
        while ( cur.next != null ) {
            cur = cur.next;
            if (cur.key == key) { cur.value = value; return;}
        }
        Node tem = new Node(key,value);
        cur.next = tem;
    }
    
    public int get(int key) {
        int h = hashIndex(key);
        Node cur = data[h];
        while ( cur.next != null ) {
            cur = cur.next;
            if (cur.key == key) {return cur.value;}
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hashIndex(key);
        Node cur = data[h];
        while ( cur.next != null ) {
            Node prev = cur;
            cur = cur.next;
            if (cur.key == key) { prev.next = cur.next; }
        }
    }
}

#leetcode 706: https://leetcode.cn/problems/design-hashmap/
