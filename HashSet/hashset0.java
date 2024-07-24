
class hashset0 {

    boolean[] judge  = new boolean[1000001];   /* 0 <= key <= 10^6 */
    
    public void add(int key) {
        judge[key] = true;
    }
    
    public void remove(int key) {
        judge[key] = false;
    }
    
    public boolean contains(int key) {
        return judge[key];
    }
}

