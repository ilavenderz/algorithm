package com.istargazer.algorithm.sort;

/**
 * 插入排序
 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
 * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
 * 如此反复循环，直到全部排好顺序
 */
public class InsertSort {

    /**
     * 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
     *
     * 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
     *
     * 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
     *
     * 将当前数放置到空着的位置，即j+1。
     */

    /**
     * 基础插入排序
     * @param sortArr
     * @param <T>
     */
    public static <T extends Comparable> void baseSort(T[] sortArr) {
        int length = sortArr.length; // 数组长度
        T temp; // 要插入的数据
        for(int index = 1; index < length; index++) {
            // 第一个元素默认为有序，从第二个元素开始
            temp = sortArr[index];
            int sortedIndex = index - 1; // 有序元素下标
            /**
             * 从后开始向前移动元素
             * 当有序元素下标大于等于0且有序元素大于要插入的元素时
             * 进行元素后移
             */
            while(sortedIndex >= 0 && sortArr[sortedIndex].compareTo(temp) > 0){
                sortArr[sortedIndex + 1] = sortArr[sortedIndex];
                sortedIndex--;
            }
            // 找到插入位置，插入元素
            sortArr[sortedIndex + 1] = temp;
        }
    }
}
