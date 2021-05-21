package com;

import java.util.ArrayList;
import java.util.List;

/* Print reversed array having all the zero's at end*/
public class ArrayProblem {

    //space complexity O(n)
    static void reverseArrayApproach1(int[] arr, int length){
        int zeroCount = 0;
        int actualLen = length-1;

        List<Integer> list = new ArrayList<>();

        for (int i = actualLen; i>=0 ;i--){
            if(arr[i] == 0){
                zeroCount++;
            } else{
                list.add(arr[i]);
            }
        }

        while(actualLen != (length - zeroCount -1)){
            list.add(0);
            actualLen--;
        }
        for (int val : list){
            System.out.print(val+",");
        }
    }

    //space complexity O(1)
    static void reverseArrayApproach2(int[] arr, int length){
        int count = 0;
        //reversed array
        for(int i = 0 ;i < length/2; i++){
            int temp = arr[i];
            arr[i] = arr[length -1 - i];
            arr[length - 1 - i] = temp;
        }
        //moving 0's
        for(int i=0 ;i<length ;i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }

        //adding zero's
        while(count < length){
            arr[count++] = 0;
        }

        for (int i : arr){
            System.out.print(i+",");
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 2, 3, 0, 9, 10, 0, 34, 8, 0, 23, 56, 12};
        int length = arr.length;

        reverseArrayApproach1(arr, length);
        System.out.println();
        reverseArrayApproach2(arr, length);
    }
}
