package com.istargazer.algorithm.recursion;

/**
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……在数学上，
 * 斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * 在现代物理、准晶体结构、化学等领域，斐波纳契数列都有直接的应用，为此，
 * 美国数学会从1963年起出版了以《斐波纳契数列季刊》为名的一份数学杂志，用于专门刊载这方面的研究成果。
 *
 *
 * 有趣的是，这样一个完全是自然数的数列，通项公式却是用无理数来表达的。而且当n趋向于无穷大时，
 * 前一项与后一项的比值越来越逼近黄金分割0.618（或者说后一项与前一项的比值小数部分越来越逼近0.618）。
 *
 *
 * 在第一个月有一对刚出生的小兔子，在第二个月小兔子变成大兔子并开始怀孕，第三个月大兔子会生下一对小兔子，
 * 并且以后每个月都会生下一对小兔子。 如果每对兔子都经历这样的出生、成熟、生育的过程，并且兔子永远不死，
 * 那么兔子的总数是如何变化的？
 *
 * y(n) = 小兔子 a(n) = 成年兔子(开始怀孕的兔子) o(n) = 老兔子(已经生产的兔子) t(n) = 第n月的兔子总数
 * y(n) = a(n-1) + o(n-1)
 * a(n) = y(n-1)
 * o(n) = a(n-1) + O(n-1)
 * t(n) = y(n)              + a(n)   + o(n)
 *      = (a(n-1) + o(n-1)) + y(n-1) + (a(n-1) + o(n-1))
 *      = (y(n-1) + a(n-1) + o(n-1)) + (a(n-1) + o(n-1))
 *      = t(n-1) + (a(n-1) + o(n-1))
 *      = t(n-1) + (y(n-2) + (a(n-2) + o(n-2)))
 *      = t(n-1) + t(n-2)
 *
 * f(n) = f(n-1) + f(n-2)
 */
public class Fibonacci {

    private static final int BASE = 2; // 开始位置

    public static final long fibonacciRecursion(int n){
        if(n > BASE)
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        return 1;
    }

    public static final long fibonacciLoop(int n){
        if(n > 1){
            long yn = 1;
            long an = 0;
            long on = 0;
            for(int i = BASE; i <= n; i++ ){
               on = an + on; // 现在的老兔子 = 上个月老兔子 + 上个月的成年兔子
               an = yn; // 现在的成年兔子 = 上个月的年轻兔子
               yn = on; // 现在的年轻兔子 = 现在的老年兔子
            }
            return yn + an + on;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fibonacciLoop(8));
        System.out.println(Fibonacci.fibonacciRecursion(8));
    }
}
