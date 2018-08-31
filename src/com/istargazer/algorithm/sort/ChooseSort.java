package com.istargazer.algorithm.sort;

/**
 * 遍历整个序列，将最小的数放在最前面。
 * 遍历剩下的序列，将最小的数放在最前面。
 * 重复第二步，直到只剩下一个数。
 */
public class ChooseSort {

    public static <T extends Comparable> void chooseSort(T[] sortArr) {
        int length = sortArr.length;
        T temp;
        int position = 0;
        for(int index = 0; index < length; index++) { //循环次数
            temp = sortArr[index];
            position = index;
            for(int unSort = index + 1; unSort < length; unSort++) { //找到最小的值和位置
                if(0 < temp.compareTo(sortArr[unSort])){
                    temp = sortArr[unSort];
                    position = unSort;
                }
            }
            // 交换
            sortArr[position] = sortArr[index];
            sortArr[index] = temp;
        }
    }
}
