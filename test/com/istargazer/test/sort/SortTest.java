package com.istargazer.test.sort;

import com.istargazer.algorithm.sort.InsertSort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        Integer[] sortArr = new Integer[]{5,3,7,1,9,11,4,25,56,23,45,78};
        InsertSort.baseSort(sortArr);
        System.out.println(Arrays.toString(sortArr));
    }
}
