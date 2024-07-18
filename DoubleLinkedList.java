public class DoubleLinkedList {

    /** make implementation and initialization of DoubleLinkedList */
    private int size;
    private Node sentfront, sentback;
    class Node {
        int val;
        Node next, prev;
        public Node(int val) {
            this.val = val;
        }
    }
    public DoubleLinkedList() {
        size = 0;
        sentfront = new Node(2024);
        sentback = new Node(2024);
        sentback.prev = sentfront;
        sentfront.next = sentback;
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
        Node p = sentfront;
        for (int i=0; i<=index; i++){
            p=p.next;
        }
        return p.val;
    }

    /** add a node at the head */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** add a node at the tail */
    public void addAtTail(int val) {
        size +=1;
        Node p = sentback.prev;
        Node q = new Node(val);
        q.next = sentback;
        q.prev = p;            
        sentback.prev = q;
        p.next = q;              
    }

    /** add a node at the position index */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        size +=1;
        Node p = sentfront;
        for (int i=0; i<index; i++) {
            p = p.next;
        }
        Node q = new Node(val);
        q.next = p.next;
        q.prev = p;            /**let the new node's prev/next ready */
        q.next.prev = q;
        q.prev.next = q;       /**use the new node to get the front/back node ready */
    }

    /** delete the node at position index */
    public void deleteAtIndex(int index) {
        if (index<0 || index>size-1 ) {
            return;
        }        
        size -=1;
        Node p = sentfront;
        for (int i=0; i<=index; i++) {
            p = p.next;
        }       
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }


}
