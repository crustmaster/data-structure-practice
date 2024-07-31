public class MinPQ<Key extends Comparable<Key> > {

    Key[] keys_array;
    public int parent(int i) {
        return (i-1)/2;
    } 

    public int leftchild(int i) {
        return 2*i+1;
    }
    public int rightchild(int i) {
        return 2*i+2;
    }

    public void swap(int i, int j) {
        Key tem = Keys[i];
        Keys[i] = Keys[j];
        Keys[j] = tem;
    }

    public void swim(int i) {
        if ( keys.[parent(i)] > keys[i] ) {
            swap(i, parent(i));
            swim(parent(i));
        }
    }

    public void add(Key k);
    public K getSmallest();
    public K removeSmallest();
    public int size();
    
} 
