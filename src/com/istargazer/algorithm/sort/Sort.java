package com.istargazer.algorithm.sort;

public abstract class Sort {

    public static final int ORDER_ASC = 1;
    public static final int ORDER_DESC = -1;
    /**
     * compare
     * @param arr
     * @param <T>
     * @return
     */
    public <T extends Comparable> T[] sort(T[] arr){
        return sort(arr,Sort.ORDER_ASC);
    }

    /**
     *
     * @param arr
     * @param order
     * @param <T>
     * @return
     */
    public abstract <T extends Comparable> T[] sort(T[] arr,int order);

    protected static <T extends Comparable> void swap(T[] arr, int from,int to){
        if(from != to){
            T temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
        }
    }
}
