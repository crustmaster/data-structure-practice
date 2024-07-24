package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K,V> {

    /* get definition and initialization of BSTMap */
    private int size;
    private Node root;
    public BSTMap() {
        size = 0 ;
        root = null;
    }
    private class Node<K,V> {
        public final K key;
        public V val;
        public Node left;
        public Node right;
        public Node(K k, V v) {
            key = k;
            val = v;
        }
    }

    /** Removes all of the mappings from this map. */
    public void clear() {
        root = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K spec_key) {
        return containsKeyHelper(root, spec_key);
    }
    private boolean containsKeyHelper(Node node, K spec_key) {
        if (node == null) {
            return false;
        }
        if (node.key == spec_key) {
            return true;
        }
        int tem = spec_key.compareTo((K) node.key);
        if ( tem < 0 ) {
            return containsKeyHelper(node.left, spec_key);
        } else {
            return containsKeyHelper(node.left, spec_key);
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. */
    public V get(K spec_key) {
        return getHelper(root, spec_key);
    }
    private V getHelper(Node node, K spec_key) {
        if ( node == null) {
            return null;
        }
        if ( node.key == spec_key) {
            return (V) node.val;
        }
        int tem = spec_key.compareTo((K) node.key);
        if ( tem < 0 ) {
            return (V) getHelper(node.left, spec_key);
        } else {
            return (V) getHelper(node.right, spec_key);
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K spec_key, V spec_val) {
        root = putHelper(root, spec_key, spec_val);
    }
    private Node putHelper(Node node, K spec_key, V spec_val) {
        if (node == null) {
            size +=1;
            return new Node (spec_key, spec_val);
        }
        if (node.key == spec_key) {
            node.val = spec_val;
        }
        int tem = spec_key.compareTo((K) node.key);
        if ( tem < 0 ) {
            node.left = putHelper(node.left, spec_key, spec_val);
        } else {
            node.right = putHelper(node.right, spec_key, spec_val);
        }
        return node;
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key) {
        throw new UnsupportedOperationException("Method not implemented yet");
}
    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    /* Iterator */
    public Iterator<K> iterator() {
        // 暂时未实现
        throw new UnsupportedOperationException("Method not implemented yet");
    }


}
