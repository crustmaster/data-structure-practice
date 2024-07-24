class MyHashSet {

    private static final int base =769;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[base];
        for (int i=0; i<base; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            if ( iterator.next()==key ) { return; }
        }
        data[h].offerLast(key);
    }
    
    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if ( element==key ) { 
                data[h].remove(element);
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            if ( iterator.next()==key ) { return true; }
        }
        return false;
    }

    private static int hash(int key) { return key % base; }
}

#705: https://leetcode.cn/problems/design-hashset/
