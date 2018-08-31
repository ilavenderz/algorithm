package com.istargazer.test.sort;

import com.istargazer.algorithm.sort.ChooseSort;
import com.istargazer.algorithm.sort.InsertSort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        Integer[] sortArr = new Integer[]{5,3,7,1,9,11,4,25,56,23,45,78,2,234,34,564,976,324,21,453,214,554,123};
        long start,end;
        start = System.currentTimeMillis();
        //InsertSort.baseSort(sortArr);
        //InsertSort.shellSort(sortArr);
        ChooseSort.chooseSort(sortArr);
        end = System.currentTimeMillis();
        System.out.println(Arrays.toString(sortArr));
        System.out.println(start - end);
    }
}
