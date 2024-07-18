public class ArrayList<T> {

    /* make definition and initialization of Arraylist*/
    private static final int default_capacity = 10;
    private Object[] elements;
    private int size;
    public ArrayList() {
        elements = new Object[default_capacity];
        size = 0;
    }
    public ArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    /* get the size of the arraylist*/
    public int getSize() {
        return size;
    }

    /* get the items at index i */
    public T get(int index) {
        if ( index >= elements.length ) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /* add an item to the arraylist */
    public void add(T t) {
        if (size == elements.length) {
            resize();
        }
        elements[size] = t;
        size +=1;
    }

    /* resize the ArrayList */
    public void resize() {
        Object[] new_elements = new Object[2* elements.length];
        System.arraycopy(elements, 0, new_elements, 0, elements.length);
        elements = new_elements;
    }

    /* delete an item at index i */
    public void remove(int index) {
        if ( index >= elements.length ) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size-1) {
            elements[index] = null;
            size -=1;
            return;
        }
        System.arraycopy(elements, index+1, elements, index, size-index-1);
        elements[size-1] = null;
        size -=1;
    }

    /* change the value at index i */
    public void reset(T t, int index) {
        if ( index >= elements.length ) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[size] = t;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("List size: " + list.getSize());

        list.remove(1);
        System.out.println("After removal:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("List size: " + list.getSize());
    }

}
