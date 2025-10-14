package com.synergisticit.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericComparableCompatator {


    public static void main(String[] args) {
        String str = """
                Str 
                Str
                """;
        System.out.println(str.length());


    }
}


sealed interface Member permits Person2{ //LINE A
    String role();
    void role(String role);
}

final record Person2(String role) implements Member{ //LINE B
    public void role(String r){
    }
};

record Student(int id, Person2 person)
{
    public String getRole(){ return person.role(); }

    public void setRole(String role){ person.role(role); } //LINE C
}

class TestClass{

    public static void m(Student m){
        if(m instanceof Student(var id, Person2(var role))){ //LINE D
            System.out.println("role = "+role);
        }
    }

    public static void main(String[] args) {
        Student s = new Student(123, new Person2("student")); //LINE E
        m(s);
        Journal j = new Journal(123,"k");
    }
}
record Journal(int id, String name){

    static int n = 0;

    public Journal{ //2
        id=id+9;
        System.out.println(id);
    }
}

