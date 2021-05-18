package com.globaliterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Design a global Iterator over 3 sorted Lists. */
public class Iterator {
    int[] arr1 = {1,4,89,100,201,205, 206};
    int[] arr2 = {2,67,90,101, 102, 103, 104, 105, 106};
    int[] arr3 = {0,49,88};
    int arraysCount = 3;
    int nextCount = 0;
    int arrayIndexCount = 0;
    int maxLen = Math.max(arr1.length, Math.max(arr2.length, arr3.length));
    List<Integer> list = new ArrayList<>();

    private int next() {
        int val = 0;
        boolean flag = false;
        if (arrayIndexCount < (maxLen -1)){
            if (nextCount % 3 == 0) {
                if (list.size() > 0) {
                    arrayIndexCount++;
                    nextCount = 0;
                    list.removeAll(list);
                }
                if (arrayIndexCount <= arr1.length-1)
                    list.add(arr1[arrayIndexCount]);
                if (arrayIndexCount <= arr2.length-1)
                    list.add(arr2[arrayIndexCount]);
                if (arrayIndexCount <= arr3.length-1)
                    list.add(arr3[arrayIndexCount]);
                Collections.sort(list);
            }
            if((nextCount < arraysCount) && (nextCount+1 <= list.size())){
                val = list.get(nextCount);
            }else{
                flag =true;
            }
        }
        nextCount++;
        if(flag){
            val = next();
        }
        return val;
    }

    public static void main(String[] args) {
        Iterator it = new Iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
