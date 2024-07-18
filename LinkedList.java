public class LinkedList {

    /* make defination and initialization of linkedList*/ 
    private int size;
    private Node sentinel;
    class Node {
        int val;
        Node next;
        public Node(int x) {
            val = x;
            next = null;
        }
    }
    public LinkedList() {
        size = 0;
        sentinel = new Node(2024);
    }

    /*get the size of the list*/
    public int size() {
        return size;
    }
    
    /* get the value of certain index */
    public int get(int index) {
        if (index<0 || index>size-1 ) {
            return -1;
        }
        Node p = sentinel;
        for (int i=0; i<=index; i++){
            p=p.next;
        }
        return p.val;
    }

    /**add a head */
    public  void addAtHead(int val) {
        size +=1;
        Node p = new Node(val);
        p.next = sentinel.next;
        sentinel.next = p;
    }

    /**add a tail */
    public void addAtTail(int val) {
        size +=1;
        Node p = sentinel;
        while (p.next!=null) {
            p=p.next;
        }
        p.next = new Node(val);
    }

    /**add a new node at position index */
    public void addAtIndex(int index, int val) {
        if ( index > size ) {
            return;
        }
        if ( index == size ) {
            addAtTail(val);
            return;
        }
        size +=1;
        Node p = sentinel;
        Node q = new Node(val);
        for (int i=0; i<index; i++){
            p=p.next;
        }        
        q.next = p.next;
        p.next = q;
    }

    /**delete a new node at position index */
    public void deleteAtIndex(int index) {
        if (index<0 || index>size-1 ) {
            return;
        }        
        size -=1;
        Node p = sentinel;
        for (int i=0; i<index; i++){
            p=p.next;
        }        
        p.next = p.next.next;        
    }
}
