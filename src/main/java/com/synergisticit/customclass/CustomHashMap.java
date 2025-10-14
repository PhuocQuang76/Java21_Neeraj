package com.synergisticit.customclass;

public class CustomHashMap <K, V> {
    // Default initial capacity
    private static final int DEFAULT_CAPACITY = 16;
    // Load factor threshold for resizing
    private static final float LOAD_FACTOR = 0.75f;

    // Array to store the buckets
    private Node<K, V>[] buckets;
    private int size = 0;

    private static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash , K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //Constructor
    public CustomHashMap() {
        buckets = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];

    }

    public int getIndex(K key,int length) {
        //key = null always set in index 0
        if (key == null) {
            return 0;
        }
        return key.hashCode() % length;
    }

    //Put a key-value pair into the map
    public V put(K key, V value) {
        //resize if needed
        if(size >= LOAD_FACTOR * buckets.length) {
            resize();
        }

        int hash = key == null ? 0 : key.hashCode();
        int index = getIndex(key, buckets.length);

        // Check if key already exists
        Node<K,V> current = buckets[index];
        while(current != null) {
            if((key == null && current.key == null) || (key != null && current.key.equals(key))){
                V oldValue = current.value;
                current.value = value; // Update existing value
                return oldValue;
            }
            current = current.next;
        }

        // Add new node at the beginning of the list
        Node<K, V> newNode = new Node<>(hash, key, value, buckets[index]);
        buckets[index] = newNode;
        size++;
        return null;
    }

    // Get a value by key
    public V get(K key) {
        int index = getIndex(key, buckets.length);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if ((key == null && current.key == null) ||
                    (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }
        return null;  // Key not found
    }

    private void resize() {
        Node<K,V> [] oldBucket = buckets;
        buckets = (Node<K,V>[]) new Node[oldBucket.length * 2];
        size = 0;

        for(Node<K,V> node : buckets){
            if(node != null) {

            }
        }
    }

    public V remove(K key) {
        int index = getIndex(key, buckets.length);
        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;

        while (current != null) {
            if ((key == null && current.key == null) ||
                    (key != null && key.equals(current.key))) {

                if (previous == null) {
                    // Remove first node in the bucket
                    buckets[index] = current.next;
                } else {
                    // Remove node in the middle/end
                    previous.next = current.next;
                }

                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a new HashMap
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        // Add some key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Get values
        System.out.println("Value for 'three': " + map.get("three"));  // 2
    }
}
