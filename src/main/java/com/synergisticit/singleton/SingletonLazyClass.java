package com.synergisticit.singleton;

import java.io.Serializable;

public class SingletonLazyClass implements Serializable, Cloneable{
    private static volatile SingletonLazyClass instance;

    //Prevent reflection
    private SingletonLazyClass() {
        if(instance !=null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static SingletonLazyClass getInstance() {
        if(instance == null) {
            //Double-checked locking
            //Prevent multiple threads from creating multiple instances
            synchronized (SingletonLazyClass.class) {
                if(instance == null) {
                    instance = new SingletonLazyClass();
                }
            }
        }
        return instance;
    }

    //Prevent deserialization
    public Object readResolve() {
        return instance;
    }

    //Prevent cloning
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("SingletonLazyClass does not support cloning");
    }
}

/*
Singleton class must satisfies following conditions:
    1. Thread Safety: Uses double-checked locking for thread safety
    2. Lazy Initialization: Instance is created only when needed
    3. Volatile Keyword: Ensures visibility of changes across threads
    4. Reflection Protection: Throws exception if someone tries to create instance via reflection
    5. Serialization Safe: Prevents multiple instances during deserialization
    6. Clone Protection: Prevents cloning of the singleton instance
 */