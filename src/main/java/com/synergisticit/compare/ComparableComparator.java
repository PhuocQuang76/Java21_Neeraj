package com.synergisticit.compare;

import java.util.*;

public class ComparableComparator  {
//    @Override
//    public int compare(ComparatorEmployee e1, ComparatorEmployee e2) {
//        return Double.compare(e1.getSalary(), e2.getSalary());
//    }
    
    public static void main(String[] args) {
        List<ComparableEmployee> list1 = new ArrayList<>();
        list1.add(new ComparableEmployee("John", 30, 50000));
        list1.add(new ComparableEmployee("Jane", 25, 90000));
        list1.add(new ComparableEmployee("Mary",46,60000));

        Collections.sort(list1);
        Iterator<ComparableEmployee> it = list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        //Comparator
        List<ComparatorEmployee> list2 = new ArrayList<>();
        list2.add(new ComparatorEmployee("John", 30, 50000));
        list2.add(new ComparatorEmployee("Jane", 25, 90000));
        list2.add(new ComparatorEmployee("Mary",46,60000));

        // Sort by salary in descending order
//        Collections.sort(list2, (e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()));
//        Collections.sort(list2, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        Collections.sort(list2, (e1, e2) -> e1.getName().compareTo(e2.getName()));
//        list2.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));

        Iterator<ComparatorEmployee> it2 = list2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}

/*
ComparableEmployee{name='John', age=30, salary=50000.0}
ComparableEmployee{name='Mary', age=46, salary=60000.0}
ComparableEmployee{name='Jane', age=25, salary=90000.0}
 */