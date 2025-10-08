package com.synergisticit.arrayList;

import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;


    // Default constructor
    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Constructor with initial capacity
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    //Methods
    //Add Element (End of List)
    public boolean add(E element) {
        int index = size + 1;
        ensureCapacity(index);  // Make sure there's space
        elements[size++] = element;  // Add element and increment size
        return true;  // Always returns true (for Collection interface)
    }

    // Add element at specific index
    public void add(int index, E element) {
        rangeCheckForAdd(index);  // Check if index is valid
        ensureCapacity(size + 1);  // Ensure capacity
        // Shift elements right to make space
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;  // Insert new element
        size++;
    }
    /*
    Source array: elements (starting at index 1: "B", "C", "D")
    Destination: elements (starting at index 2)
    Number of elements to copy: 3 (size - index = 4 - 1 = 3)
     */


    // Get element by index
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work
        return oldValue;
    }

    // Get current size of the list
    public int size() {
        return size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clear all elements
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Convert to array
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.append(']').toString();
    }


    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void rangeCheckForAdd(int index) {
        // Allows index == size for adding at the end
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {  // If we need more space
            int newCapacity = elements.length + (elements.length  / 2);  // 1.5x current size
            if (newCapacity < minCapacity) {  // Handle case when 1.5x isn't enough
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);  // Create new larger array
        }
    }



    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Orange");  // Insert at specific position

        System.out.println(list);  // [Apple, Orange, Banana]
        System.out.println("Size: " + list.size());  // 3

        // Removing element
        String removed = list.remove(0);
        System.out.println("Removed: " + removed);  // Apple
        System.out.println(list);  // [Orange, Banana]
    }
}
