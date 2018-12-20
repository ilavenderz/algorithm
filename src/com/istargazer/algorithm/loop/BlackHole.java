package com.istargazer.algorithm.loop;

import com.istargazer.algorithm.sort.ChooseSort;
import com.istargazer.commonutils.math.NumberUtils;

public class BlackHole {


    public static final long calcBlackHoleNumber(long number){
        Byte[] bytes = NumberUtils.splitNumber(number);
        int size = bytes.length;
        // sort number
        ChooseSort.chooseSort(bytes);
        long min = createMinNumber(bytes);
        long max = createMaxNumber(bytes);
        long result = max - min;
        long temp = 0;
        do{
            temp = result;
            bytes = NumberUtils.splitNumber(result,size);
            ChooseSort.chooseSort(bytes);
            min = createMinNumber(bytes);
            max = createMaxNumber(bytes);
            result = max - min;
        }while(temp != result);
        return result;
    }

    private static long createMaxNumber(Byte[] bytes){
        long result = 0;
        for(int i = 0; i < bytes.length; i++){
            result += bytes[i] * Math.pow(10,i);
        }
        return result;
    }

    private static long createMinNumber(Byte[] bytes){
        long result = 0;
        int size = bytes.length - 1;
        for(int i = 0; i < bytes.length; i++){
            result += bytes[i] * Math.pow(10,size - i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(BlackHole.calcBlackHoleNumber(100));
    }
}
